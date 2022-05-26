package com.deathnote.api.repository

import com.deathnote.api.model.domain.Summoner
import org.springframework.data.jpa.repository.JpaRepository

interface SummonerRepository : JpaRepository<Summoner, Long> {

}
