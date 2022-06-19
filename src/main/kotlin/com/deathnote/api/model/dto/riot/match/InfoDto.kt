package com.deathnote.api.model.dto.riot.match

data class InfoDto(
    val gameCreation: Long? = null,
    val gameDuration: Long? = null,
    val gameEndTimestamp: Long? = null,
    val gameId: Long? = null,
    val gameMode: String? = null,
    val gameName: String? = null,
    val gameStartTimestamp: Long? = null,
    val gameType: String? = null,
    val gameVersion: String? = null,
    val mapId: Int? = null,
    val participants: List<ParticipantDto>? = null,
    val platformId: String? = null,
    val queueId: Int? = null,
    val teams: List<TeamDto>? = null
)