package com.deathnote.api.controller

import com.deathnote.api.service.DeathnoteService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v3/deathnote")
class DeathnoteController(
    private val deathnoteService: DeathnoteService
) {
    fun getSummoner() {

    }
}