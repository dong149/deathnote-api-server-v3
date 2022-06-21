package com.deathnote.api.model.vo

import com.deathnote.api.model.domain.Summoner

data class SummonerInfo(
    val summonerName: String,
    val accountId: String,
    val score: Int?
) {
    companion object {
        fun of(summoner: Summoner): SummonerInfo {
            return SummonerInfo(
                summonerName = summoner.summonerName,
                accountId = summoner.accountId,
                score = summoner.score
            )
        }
    }
}

data class SummonerInfoDto(
    val summonerName: String,
    val accountId: String,
    val score: Int?
) {
    companion object {
        fun of(summoner: SummonerInfo): SummonerInfoDto {
            return SummonerInfoDto(
                summonerName = summoner.summonerName,
                accountId = summoner.accountId,
                score = summoner.score
            )
        }
    }
}

