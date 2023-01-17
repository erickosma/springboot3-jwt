package com.springjwt.springboot3jwt.adapter.service

import com.springjwt.springboot3jwt.domain.entity.User
import io.jsonwebtoken.JwtBuilder
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.Date

@Component
class TokenService {

    private val expirationIimeMile = 1800000L
    private val key ="String-aleatoria"

    fun generateToken(user: User): String? {
        val expration = Date(System.currentTimeMillis() + expirationIimeMile)

        return Jwts.builder()
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setSubject("User test")
            .setExpiration(expration)
            .signWith(SignatureAlgorithm.HS256, key)
            .compact()
    }
}