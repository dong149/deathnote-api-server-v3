package com.deathnote.api.model.dto.riot.match

data class MetadataDto(
    var dataVersion: String? = null,
    val matchId: String? = null,
    val participants: List<String>? = null
)