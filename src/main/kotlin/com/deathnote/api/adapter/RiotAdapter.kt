package com.deathnote.api.adapter

import com.deathnote.api.exception.DeathnoteException
import com.deathnote.api.exception.ErrorCode
import com.deathnote.api.model.dto.riot.SummonerDto
import com.deathnote.api.utils.logger
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Service
class RiotAdapter(
    @Value("\${riot.API_KEY}")
    private val apiKey: String,
    private val restTemplate: RestTemplate,
    private val objectMapper: ObjectMapper
) {
    private val log = logger()

    fun getSummonerDto(summonerName: String): SummonerDto {
        val requestUrl = UriComponentsBuilder.fromUriString("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/")
            .path(summonerName.replace(" ".toRegex(), ""))
            .queryParam("api_key", apiKey)
            .toUriString()

        log.info("get summoner request url : {}", requestUrl)

        val uri = URI(requestUrl)

        return try {
            objectMapper.readValue(
                restTemplate.getForEntity(uri, String::class.java).body,
                SummonerDto::class.java
            )
        } catch (ex: Exception) {
            log.error("get summoner by name error : {}, name : {}", ex.localizedMessage, summonerName)
            throw DeathnoteException(ErrorCode.SUMMONER_NOT_FOUND)
        }
    }
}