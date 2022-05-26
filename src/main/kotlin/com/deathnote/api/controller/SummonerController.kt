package com.deathnote.api.controller

import com.deathnote.api.model.domain.Summoner
import com.deathnote.api.service.SummonerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/summoner")
class SummonerController (private val summonerService: SummonerService){

    @GetMapping
    fun getSummoner() : ResponseEntity<Summoner> {
        return ResponseEntity.ok(summonerService.getSummoner())
    }
}