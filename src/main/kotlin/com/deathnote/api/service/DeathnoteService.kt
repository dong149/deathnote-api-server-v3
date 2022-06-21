package com.deathnote.api.service

import com.deathnote.api.adapter.RiotAdapter
import org.springframework.stereotype.Service

@Service
class DeathnoteService(
    private val riotApiAdapter: RiotAdapter
) {
    fun getMatchInfo() {

    }
}
