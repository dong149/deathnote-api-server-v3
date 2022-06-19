package com.deathnote.api.controller

import com.deathnote.api.service.MatchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v3/match")
class MatchController(private val matchService: MatchService) {
    @GetMapping
    fun getSummoner(@RequestParam puuid: String): ResponseEntity<List<String>> {
        return ResponseEntity.ok(matchService.getMatchList(puuid))
    }
}