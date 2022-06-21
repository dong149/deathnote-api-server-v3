package com.deathnote.api.model.dto.riot

import com.deathnote.api.model.domain.Summoner

data class SummonerDto(
    val accountId: String,
    val profileIconId: Int,
    val revisionDate: Long,
    val name: String,
    val id: String,
    val puuid: String,
    val summonerLevel: Long
) {
    fun toEntity(summonerDto: SummonerDto): Summoner {
        return Summoner(
            accountId = summonerDto.accountId,
            summonerId = summonerDto.id,
            summonerName = summonerDto.name,
            profileIconId = summonerDto.profileIconId,
            puuid = summonerDto.puuid,
            summonerLevel = summonerDto.summonerLevel
        )
    }
}