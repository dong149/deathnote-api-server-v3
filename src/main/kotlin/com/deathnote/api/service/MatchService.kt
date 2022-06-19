package com.deathnote.api.service

import com.deathnote.api.adapter.RiotAdapter
import com.deathnote.api.constant.QueueType
import org.springframework.stereotype.Service

@Service
class MatchService(private val riotAdapter: RiotAdapter) {
    fun getMatchList(puuid: String): List<String>? {
        return riotAdapter.getMatchList(puuid, QueueType.SOLO_RANK_QUEUE)
    }
}