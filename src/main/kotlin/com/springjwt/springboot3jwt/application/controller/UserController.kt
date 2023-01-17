package com.springjwt.springboot3jwt.application.controller

import com.springjwt.springboot3jwt.adapter.repository.UserRepository
import com.springjwt.springboot3jwt.domain.entity.User
import com.springjwt.springboot3jwt.domain.request.CreateUser
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
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
    fun createUser(@RequestBody createUser: CreateUser): Mono<User> {
        return userRepository.save(createUser.toUser())
    }

    @GetMapping
    fun findAll(): Flux<User> {
        return userRepository.findAll()
    }


    @GetMapping("/test")
    fun serverResponseMono(): ResponseEntity<*>? {
        return ResponseEntity
            .ok()
            .body(Flux.just("test"))
    }
}