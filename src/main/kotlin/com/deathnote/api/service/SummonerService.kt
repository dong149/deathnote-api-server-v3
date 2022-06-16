package com.deathnote.api.service

import com.deathnote.api.adapter.RiotAdapter
import com.deathnote.api.model.domain.Summoner
import com.deathnote.api.model.dto.riot.SummonerDto
import com.deathnote.api.utils.logger
import org.springframework.stereotype.Service

@Service
class SummonerService(
    private val riotAdapter: RiotAdapter
) {
    private val log = logger()

    fun getSummoner(): Summoner {
        return Summoner(
            accountId = "accountId",
            summonerId = "test",
            summonerName = "왼손잡이들",
            summonerDecodedName = "test"
        )
    }

    fun getSummonerDto(summonerName: String): SummonerDto {
        log.info("request summoner dto. summonerName : {}", summonerName)
        return riotAdapter.getSummonerDto(summonerName)
    }
}