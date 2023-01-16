package com.springjwt.springboot3jwt.application.controller

import com.springjwt.springboot3jwt.adapter.repository.UserRepository
import com.springjwt.springboot3jwt.domain.entity.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/user")
class UserController(private val userRepository: UserRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody user: User): Mono<User> {
        return userRepository.save(user)
    }

    @GetMapping
    fun findAll(): Flux<User?>? {
        return userRepository.findAll()
    }
}