package com.deathnote.api.service

import com.deathnote.api.model.domain.Summoner
import com.deathnote.api.utils.logger
import org.springframework.stereotype.Service

@Service
class SummonerService {
    private val log = logger()

    fun getSummoner(): Summoner {
        return Summoner("임시")
    }
}