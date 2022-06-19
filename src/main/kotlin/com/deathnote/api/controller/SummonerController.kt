package com.deathnote.api.controller

import com.deathnote.api.model.domain.Summoner
import com.deathnote.api.model.dto.riot.SummonerDto
import com.deathnote.api.service.SummonerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v3/summoner")
class SummonerController(private val summonerService: SummonerService) {

    @GetMapping
    fun getSummoner(): ResponseEntity<Summoner> {
        return ResponseEntity.ok(summonerService.getSummoner())
    }

    @GetMapping("/dto")
    fun getSummonerDto(@RequestParam summonerName: String): ResponseEntity<SummonerDto> {
        return ResponseEntity.ok(summonerService.getSummonerDto(summonerName))
    }
}