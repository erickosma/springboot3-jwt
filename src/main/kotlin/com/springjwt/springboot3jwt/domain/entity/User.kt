package com.springjwt.springboot3jwt.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("user_login")
data class User (
    @Id
    @Column("id")
    val id: Long? = null,
    @Column("email")
    val email: String? = null,
    @Column("pswd")
    val pswd: String? = null,
    @Column("created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)