package com.deathnote.api.adapter

import com.deathnote.api.constant.QueueType
import com.deathnote.api.exception.DeathnoteException
import com.deathnote.api.exception.ErrorCode
import com.deathnote.api.model.dto.riot.SummonerDto
import com.deathnote.api.model.dto.riot.match.MatchDto
import com.deathnote.api.utils.logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Service
class RiotAdapter(
    @Value("\${riot.API_KEY}")
    private val apiKey: String,
    private val restTemplate: RestTemplate
) {
    private val log = logger()

    fun getSummonerDto(summonerName: String): SummonerDto? {
        val requestUrl = UriComponentsBuilder.fromUriString("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/")
            .path(summonerName.replace(" ".toRegex(), ""))
            .queryParam("api_key", apiKey)
            .toUriString()

        log.info("get summoner request url : {}", requestUrl)

        val uri = URI(requestUrl)

        return try {
            restTemplate.getForEntity(uri, SummonerDto::class.java).body
        } catch (ex: Exception) {
            log.error("get summoner by name error : {}, name : {}", ex.localizedMessage, summonerName)
            throw DeathnoteException(ErrorCode.SUMMONER_NOT_FOUND)
        }
    }

    fun getMatchList(puuid: String, queueType: QueueType, count: Int = 10): List<String>? {
        val requestUrl = UriComponentsBuilder
            .fromUriString(
                "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/$puuid/ids"
            )
            .queryParam("queue", queueType.queue)
            .queryParam("api_key", apiKey)
            .queryParam("type", "ranked")
            .queryParam("start", 0)
            .queryParam("count", count)
            .toUriString()

        log.info("get match list request url : {}", requestUrl)

        val uri = URI(requestUrl)

        return try {
            return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                object : ParameterizedTypeReference<List<String>>() {})
                .body
        } catch (ex: Exception) {
            log.error("get match list error : {}, puuid : {}", ex.localizedMessage, puuid)
            throw DeathnoteException(ErrorCode.MATCH_LIST_NOT_FOUNT)
        }
    }

    fun getMatchDtoByMatchId(matchId: String): MatchDto? {
        val requestUrl = UriComponentsBuilder
            .fromUriString("https://asia.api.riotgames.com/lol/match/v5/matches/")
            .path(matchId)
            .queryParam("api_key", apiKey)
            .toUriString()

        log.info("get match dto by match id request url : {}", requestUrl)

        val uri = URI(requestUrl)

        return try {
            restTemplate.getForEntity(uri, MatchDto::class.java).body
        } catch (ex: Exception) {
            log.error("get match dto by match id error : {}, match id : {}", ex.localizedMessage, matchId)
            throw DeathnoteException(ErrorCode.MATCH_LIST_NOT_FOUNT)
        }
    }
}