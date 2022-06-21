package com.deathnote.api.service

import com.deathnote.api.adapter.RiotAdapter
import com.deathnote.api.exception.DeathnoteException
import com.deathnote.api.exception.ErrorCode
import com.deathnote.api.model.domain.Summoner
import com.deathnote.api.model.dto.riot.SummonerDto
import com.deathnote.api.model.vo.SummonerInfo
import com.deathnote.api.repository.SummonerRepository
import com.deathnote.api.utils.logger
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SummonerService(
    private val riotAdapter: RiotAdapter,
    private val summonerRepository: SummonerRepository
) {
    private val log = logger()

    // TODO : 제거
    fun getSummonerInfo(): Summoner {
        return Summoner(
            accountId = "accountId",
            summonerId = "test",
            summonerName = "왼손잡이들",
            puuid = "test puuid",
            profileIconId = 0
        )
    }

    @Transactional(readOnly = true)
    fun getSummonerInfo(name: String): SummonerInfo {
        var summoner = summonerRepository.findBySummonerName(name)

        if (summoner == null) {
            val summonerDto = riotAdapter.getSummonerDto(name) ?: throw DeathnoteException(ErrorCode.SUMMONER_NOT_FOUND)
            summoner = summonerDto.toEntity(summonerDto)
        }

        return SummonerInfo.of(summonerRepository.save(summoner))
    }

    fun getSummonerDto(summonerName: String): SummonerDto? {
        log.info("request summoner dto. summonerName : {}", summonerName)
        return riotAdapter.getSummonerDto(summonerName)
    }
}