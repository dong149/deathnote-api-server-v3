package com.deathnote.api.model.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "summoners")
class Summoner(
    @Id
    val accountId: String,

    @Column(nullable = false)
    val summonerId: String,

    @Column(nullable = false)
    val summonerName: String,

    @Column(nullable = false)
    val puuid: String,

    @Column(nullable = true)
    val profileIconId: Int? = null,

    @Column(nullable = true)
    val summonerLevel: Long = 1,

    @Column(nullable = true)
    val score: Int? = null,

    @Column(nullable = true)
    val matchCount: Int? = null,

    @Column(nullable = true)
    val win: Int? = null,

    @Column(nullable = true)
    val lose: Int? = null,

    @Column(nullable = true)
    val winningRate: Int? = null,

    @Column(nullable = true)
    val tier: String? = null
) : BaseEntity()
