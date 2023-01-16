package com.springjwt.springboot3jwt.adapter.repository

import com.springjwt.springboot3jwt.domain.entity.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface UserRepository : ReactiveCrudRepository<User, Long>