package com.deathnote.api.service

import com.deathnote.api.repository.SummonerRepository
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test

internal class SummonerServiceTest {

    @InjectMockKs
    lateinit var summonerService: SummonerService

    @MockK
    lateinit var summonerRepository: SummonerRepository

    @Test
    fun `간단한 테스트`() {

    }




}