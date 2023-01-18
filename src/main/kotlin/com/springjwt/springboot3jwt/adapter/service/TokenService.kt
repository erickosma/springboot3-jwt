package com.springjwt.springboot3jwt.adapter.service

import com.google.gson.Gson
import com.springjwt.springboot3jwt.domain.dto.AuthUser
import com.springjwt.springboot3jwt.domain.entity.User
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*
import javax.xml.bind.DatatypeConverter


@Component
class TokenService {

    private val expirationIimeMile = 1800000L
    private val key ="String-aleatoria"
    private val bearer = "Bearer "
    private var gson = Gson()

    fun generateToken(user: User): String? {
        val expration = Date(System.currentTimeMillis() + expirationIimeMile)
        val jsonString = gson.toJson(AuthUser(user))

        return Jwts.builder()
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setSubject(jsonString)
            .setExpiration(expration)
            .signWith(SignatureAlgorithm.HS256, key)
            .compact()
    }

    fun decode(token: String): AuthUser? {
        val clearToken = token.replace(bearer, "")
        val claims = Jwts.parser()
            .setSigningKey(DatatypeConverter.parseBase64Binary(key))
            .parseClaimsJws(clearToken)
            .body
        return gson.fromJson(claims.subject, AuthUser::class.java)
    }
}