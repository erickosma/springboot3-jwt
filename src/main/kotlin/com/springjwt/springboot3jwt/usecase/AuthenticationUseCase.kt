package com.springjwt.springboot3jwt.usecase

import com.springjwt.springboot3jwt.adapter.repository.UserRepository
import com.springjwt.springboot3jwt.adapter.service.TokenService
import com.springjwt.springboot3jwt.domain.dto.AuthUser
import com.springjwt.springboot3jwt.domain.exception.InvalidLoginException
import com.springjwt.springboot3jwt.domain.request.LoginUser
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.error


@Service
class AuthenticationUseCase(
    private val userRepository: UserRepository,
    private val tokenService: TokenService
) {

    fun execute(loginUser: LoginUser): Mono<String>? {
        val login = loginUser.toUser()
        return userRepository.findByEmail(login.email!!)?.flatMap {
            if (it.pswd == login.pswd) {
                Mono.just(tokenService.generateToken(it)!!)
            } else {
                error(InvalidLoginException("Email or password invalid"))
            }
        }
    }

    fun decode(token: String): AuthUser? {
        return tokenService.decode(token)
    }
}