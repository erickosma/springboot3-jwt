package com.springjwt.springboot3jwt.adapter.repository

import com.springjwt.springboot3jwt.domain.entity.User
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Mono

interface UserRepository : R2dbcRepository<User, Long>{

    fun findByEmail(email: String): Mono<User>?
}