package com.springjwt.springboot3jwt.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("user_login")
data class User (
    @Id
    @Column("id")
    private val id: Long? = null,
    @Column("email")
    private val email: String? = null,
    @Column("pswd")
    private val pswd: String? = null,
)