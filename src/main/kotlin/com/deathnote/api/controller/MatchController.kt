package com.deathnote.api.controller

import com.deathnote.api.model.dto.riot.match.MatchDto
import com.deathnote.api.service.MatchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v3/matches")
class MatchController(private val matchService: MatchService) {
    @GetMapping("/list")
    fun getMatchList(@RequestParam puuid: String): ResponseEntity<List<String>> {
        return ResponseEntity.ok(matchService.getMatchList(puuid))
    }

    @GetMapping("/{matchId}")
    fun getMatchDto(@PathVariable matchId: String): ResponseEntity<MatchDto> {
        return ResponseEntity.ok(matchService.getMatchByMatchId(matchId))
    }
}