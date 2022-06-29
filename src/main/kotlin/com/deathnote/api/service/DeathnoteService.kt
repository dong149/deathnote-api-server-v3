package com.deathnote.api.service

import com.deathnote.api.adapter.RiotAdapter
import com.deathnote.api.exception.DeathnoteException
import com.deathnote.api.exception.ErrorCode
import com.deathnote.api.model.dto.riot.match.MatchDto
import com.deathnote.api.utils.logger
import org.springframework.stereotype.Service

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
        }
    }

    private fun calculateMatchScore(matchDto: MatchDto, puuid: String) {
        val ownParticipantId = getOwnParticipantId(matchDto.metadata?.participants, puuid)
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
