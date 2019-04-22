package ua.nure.nosql.notes.service

import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.nosql.notes.entity.User
import ua.nure.nosql.notes.repository.UserRepository

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {

    fun insert(user: User) = userRepository.run {
        if (existsUserByUserName(user.userName)) throw RuntimeException("User with same user name already exist.")
        user.id = ObjectId.get()
        save(user)
    }

    fun getAll() = userRepository.findAll()

    fun getById(id: ObjectId) = userRepository.findById(id)
            .orElseThrow { RuntimeException("User with such id does not exist.") }


}