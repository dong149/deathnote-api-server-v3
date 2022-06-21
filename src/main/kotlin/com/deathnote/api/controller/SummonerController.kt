package com.deathnote.api.controller

import com.deathnote.api.model.domain.Summoner
import com.deathnote.api.model.dto.SummonerInfoDto
import com.deathnote.api.model.dto.riot.SummonerDto
import com.deathnote.api.service.SummonerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v3/summoners")
class SummonerController(private val summonerService: SummonerService) {

    @GetMapping
    fun getSummoner(): ResponseEntity<Summoner> {
        return ResponseEntity.ok(summonerService.getSummoner())
    }

    @GetMapping("/{summonerName}")
    fun search(@PathVariable summonerName: String): ResponseEntity<SummonerInfoDto> {
        val summonerInfoDto = SummonerInfoDto.of(summonerService.getSummoner(summonerName))

        return ResponseEntity.ok(summonerInfoDto)
    }

    @GetMapping("/dto")
    fun getSummonerDto(@RequestParam summonerName: String): ResponseEntity<SummonerDto> {
        return ResponseEntity.ok(summonerService.getSummonerDto(summonerName))
    }
}