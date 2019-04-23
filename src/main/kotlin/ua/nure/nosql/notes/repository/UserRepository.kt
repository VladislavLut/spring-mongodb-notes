package ua.nure.nosql.notes.repository

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import ua.nure.nosql.notes.entity.User
import java.util.*

interface UserRepository : MongoRepository<User, ObjectId> {

    fun existsUserByUserName(userName: String): Boolean

    fun findUserByUserName(name: String): Optional<User>

    fun findUserByUserNameAndPassword(name: String, password: String): Optional<User>
}