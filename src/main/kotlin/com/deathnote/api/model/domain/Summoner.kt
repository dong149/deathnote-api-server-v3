package com.deathnote.api.model.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "summoner")
data class Summoner(
    @Column
    val name: String
) : AuditEntity()
