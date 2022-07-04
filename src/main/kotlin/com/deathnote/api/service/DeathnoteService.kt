package com.deathnote.api.service

import com.deathnote.api.adapter.RiotAdapter
import com.deathnote.api.constant.Feature
import com.deathnote.api.exception.DeathnoteException
import com.deathnote.api.exception.ErrorCode
import com.deathnote.api.model.dto.riot.match.ParticipantDto
import com.deathnote.api.utils.logger
import org.springframework.stereotype.Service
import kotlin.reflect.full.memberProperties

@Service
class DeathnoteService(
    private val riotApiAdapter: RiotAdapter,
    private val matchService: MatchService
) {
    private val log = logger()

    fun loadSummonerInfo() {

    }

    private fun getMatchInfo(puuid: String, accountId: String) {
        val matchList = matchService.getMatchList(puuid)


        matchList?.forEach {
            val matchDto = riotApiAdapter.getMatchDtoByMatchId(it)
            val participants = matchDto?.metadata?.participants
            val ownParticipantId = getOwnParticipantId(participants, puuid)
        }
    }

    private fun calculateMatchScore(participantDto: ParticipantDto): Long {
        var score = 0L
        participantDto::class.memberProperties.forEach {
            val feature = Feature.getFeatureOf(it.name)
            if (feature != null) {
                val value = it.getter.call(this) as Long
                val weight = feature.weight
                score += value + weight
            }
        }

        // TODO : KDA 추가해야된다.
        return score
    }

    private fun getOwnParticipantId(participants: List<String>?, puuid: String): Int {
        if (participants == null) {
            log.error("there is no participants. puuid : {}", puuid)
            throw DeathnoteException(ErrorCode.MATCH_INFO_EMPTY)
        }

        for (i in participants.indices) {
            if (puuid == participants[i]) {
                return i
            }
        }
        log.error("there is no matched participant Id. puuid : {}", puuid)
        return 0
    }
}
