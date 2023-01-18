package com.springjwt.springboot3jwt.application.controller

import com.springjwt.springboot3jwt.domain.dto.AuthUser
import com.springjwt.springboot3jwt.domain.request.LoginUser
import com.springjwt.springboot3jwt.usecase.AuthenticationUseCase
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/auth")
class AuthController(private val authenticationUseCase: AuthenticationUseCase) {

    @PostMapping("/token")
    fun getToken(@RequestBody loginUser: LoginUser): ResponseEntity<Mono<String>> {
        val token  = authenticationUseCase.execute(loginUser)
        return ResponseEntity.ok()
            .body(token)
    }

    @GetMapping("/token")
    fun decode(@RequestHeader(HttpHeaders.AUTHORIZATION) token: String): ResponseEntity<AuthUser> {
        val user  = authenticationUseCase.decode(token)
        return ResponseEntity.ok()
            .body(user)
    }
}