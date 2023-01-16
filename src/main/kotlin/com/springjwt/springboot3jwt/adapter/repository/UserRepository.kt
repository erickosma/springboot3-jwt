package com.springjwt.springboot3jwt.adapter.repository

import com.springjwt.springboot3jwt.domain.entity.User
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface UserRepository : R2dbcRepository<User, Long>