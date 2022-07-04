package com.deathnote.api.model.dto.riot.match

import kotlin.reflect.full.memberProperties

data class ParticipantDto(
    val participantId: Int? = null,
    val teamId: Int? = null,
    val assists: Int? = null,
    val baronKills: Int? = null,
    val bountyLevel: Int? = null,
    val champExperience: Int? = null,
    val champLevel: Int? = null,
    val championId: Int? = null,
    val championName: String? = null,
    val consumablesPurchased: Int? = null,
    val damageDealtToBuildings: Int? = null,
    val damageDealtToObjectives: Int? = null,
    val damageDealtToTurrets: Int? = null,
    val damageSelfMitigated: Int? = null,
    val deaths: Int? = null,
    val detectorWardsPlaced: Int? = null,
    val doubleKills: Int? = null,
    val dragonKills: Int? = null,
    val firstBloodAssist: Boolean? = null,
    val firstBloodKill: Boolean? = null,
    val firstTowerAssist: Boolean? = null,
    val firstTowerKill: Boolean? = null,
    val gameEndedInEarlySurrender: Boolean? = null,
    val gameEndedInSurrender: Boolean? = null,
    val goldEarned: Int? = null,
    val goldSpent: Int? = null,
    val individualPosition: String? = null,
    val inhibitorKills: Int? = null,
    val inhibitorTakedowns: Int? = null,
    val inhibitorsLost: Int? = null,
    val itemsPurchased: Int? = null,
    val killingSprees: Int? = null,
    val kills: Int? = null,
    val lane: String? = null,
    val largestCriticalStrike: Int? = null,
    val largestKillingSpree: Int? = null,
    val largestMultiKill: Int? = null,
    val longestTimeSpentLiving: Int? = null,
    val magicDamageDealt: Int? = null,
    val magicDamageDealtToChampions: Int? = null,
    val magicDamageTaken: Int? = null,
    val neutralMinionsKilled: Int? = null,
    val nexusKills: Int? = null,
    val nexusTakedowns: Int? = null,
    val nexusLost: Int? = null,
    val objectivesStolen: Int? = null,
    val objectivesStolenAssists: Int? = null,
    val pentaKills: Int? = null,
    val physicalDamageDealt: Int? = null,
    val physicalDamageDealtToChampions: Int? = null,
    val physicalDamageTaken: Int? = null,
    val profileIcon: Int? = null,
    val puuid: String? = null,
    val quadraKills: Int? = null,
    val riotIdName: String? = null,
    val riotIdTagline: String? = null,
    val role: String? = null,
    val sightWardsBoughtInGame: Int? = null,
    val summonerId: String? = null,
    val summonerLevel: Int? = null,
    val summonerName: String? = null,
    val teamEarlySurrendered: Boolean? = null,
    val teamPosition: String? = null,
    val totalDamageDealt: Int? = null,
    val totalDamageDealtToChampions: Int? = null,
    val totalDamageShieldedOnTeammates: Int? = null,
    val totalDamageTaken: Int? = null,
    val totalHeal: Int? = null,
    val totalHealsOnTeammates: Int? = null,
    val totalMinionsKilled: Int? = null,
    val totalTimeCCDealt: Int? = null,
    val totalTimeSpentDead: Int? = null,
    val totalUnitsHealed: Int? = null,
    val tripleKills: Int? = null,
    val trueDamageDealt: Int? = null,
    val trueDamageDealtToChampions: Int? = null,
    val trueDamageTaken: Int? = null,
    val turretKills: Int? = null,
    val turretTakedowns: Int? = null,
    val turretsLost: Int? = null,
    val unrealKills: Int? = null,
    val visionScore: Int? = null,
    val visionWardsBoughtInGame: Int? = null,
    val wardsKilled: Int? = null,
    val wardsPlaced: Int? = null,
    val win: Boolean? = null
) {
    fun printTest() {
        this::class.memberProperties.forEach {
            println(it.name)
            println(it.getter.call(this))
        }
    }
}