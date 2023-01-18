package com.springjwt.springboot3jwt.domain.dto

import com.springjwt.springboot3jwt.domain.entity.User

data class AuthUser(
    val id: Long,
    val email: String,
){
    constructor(user: User) : this(id = user.id!!, email= user.email!!)
}
