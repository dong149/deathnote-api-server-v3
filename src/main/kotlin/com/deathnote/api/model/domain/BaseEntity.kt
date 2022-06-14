package com.deathnote.api.model.domain

import com.deathnote.api.utils.DateUtils
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    var id: Long = 0L

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    var createdAt: LocalDateTime = DateUtils.utcNow()

    @LastModifiedDate
    @Column(name = "updated_at", updatable = true, nullable = false)
    var updatedAt: LocalDateTime = DateUtils.utcNow()
}
