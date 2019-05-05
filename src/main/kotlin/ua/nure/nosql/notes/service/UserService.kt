package ua.nure.nosql.notes.service

import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ua.nure.nosql.notes.entity.User
import ua.nure.nosql.notes.exception.BadRequestException
import ua.nure.nosql.notes.repository.UserRepository

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {

    fun save(user: User) = userRepository.run {
        if (existsUserByUserName(user.userName)) throw RuntimeException("User with same user name already exist.")
        user.password = passwordEncoder.encode(user.password)
        save(user)
    }

    fun getAll() = userRepository.findAll()

    fun getById(id: ObjectId) = userRepository.findById(id)
            .orElseThrow { BadRequestException("User with such id does not exist.") }

    fun getByUserName(name: String) = userRepository.findUserByUserName(name)
            .orElseThrow { BadRequestException("User with such user name does not exist.") }

    fun getByUserNameAndPassword(name: String, password: String) = userRepository.findUserByUserNameAndPassword(name, password)
            .orElseThrow { BadRequestException("User with such credentials does not exist.") }

}