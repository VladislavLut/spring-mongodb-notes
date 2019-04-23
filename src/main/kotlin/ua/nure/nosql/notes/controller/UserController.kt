package ua.nure.nosql.notes.controller

import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.nure.nosql.notes.entity.User
import ua.nure.nosql.notes.service.UserService
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/users/")
class UserController @Autowired constructor(private val userService: UserService) {

    @GetMapping
    fun getAllUsers() = userService.getAll()

    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<Unit> {
        userService.save(user)
        return ResponseEntity(HttpStatus.CREATED)
    }

}