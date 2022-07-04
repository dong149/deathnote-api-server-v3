package com.deathnote.api.service

import com.deathnote.api.adapter.RiotAdapter
import com.deathnote.api.constant.QueueType
import com.deathnote.api.model.dto.riot.match.MatchDto
import com.deathnote.api.utils.logger
import org.springframework.stereotype.Service

@Service
class MatchService(private val riotAdapter: RiotAdapter) {
    private var log = logger()

    fun getMatchList(puuid: String): List<String>? {
        return riotAdapter.getMatchList(puuid, QueueType.SOLO_RANK_QUEUE)
    }

    fun getMatchByMatchId(matchId: String): MatchDto? {
        val test = riotAdapter.getMatchDtoByMatchId(matchId)

        test?.info?.participants?.forEach {
            it.printTest()
        }

        return test
    }
}