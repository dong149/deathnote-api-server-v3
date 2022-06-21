package com.deathnote.api.model.dto

import com.deathnote.api.model.domain.Summoner

data class SummonerInfoDto(
    val summonerName: String,
    val accountId: String,
    val score: Int?
) {
    companion object {
        fun of(summoner: Summoner): SummonerInfoDto {
            return SummonerInfoDto(
                summonerName = summoner.summonerName,
                accountId = summoner.accountId,
                score = summoner.score
            )
        }
    }
}