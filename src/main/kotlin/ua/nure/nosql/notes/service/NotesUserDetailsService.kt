package ua.nure.nosql.notes.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import ua.nure.nosql.notes.config.Role
import ua.nure.nosql.notes.exception.BadRequestException
import ua.nure.nosql.notes.repository.UserRepository

@Component
class NotesUserDetailsService : UserDetailsService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findUserByUserName(username)
                .orElseThrow { BadRequestException("User with such user name does not exist.") }

        val authorities = listOf(SimpleGrantedAuthority(Role.USER.authority))

        return User(user.userName, user.password, authorities)
    }
}