package com.springjwt.springboot3jwt.domain.request

import com.springjwt.springboot3jwt.domain.entity.User

data class LoginUser(
    val email: String,
    val pswd: String
) {
    fun toUser() =
        User(id = null, email = this.email, pswd = this.pswd)

}
