package ua.nure.nosql.notes.controller

import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.nure.nosql.notes.entity.Note
import ua.nure.nosql.notes.service.NoteService

@RestController
@RequestMapping("/notes/")
class NoteController @Autowired constructor(private val noteService: NoteService) {

    @GetMapping
    fun getAllNotes() = noteService.getAll()

    @GetMapping("{$PARAM_ID}")
    fun getNote(@PathVariable(PARAM_ID) id: ObjectId) = noteService.getById(id)

    @GetMapping("/userId/{$PARAM_USER_ID}")
    fun getUserNotes(@PathVariable(PARAM_USER_ID) userId: ObjectId) = noteService.getByUserId(userId)

    @PostMapping
    fun createNote(@RequestBody note: Note): ResponseEntity<Unit> {
        //TODO: get user id from auth header and put his id into the note model
        noteService.save(note)
        return ResponseEntity(HttpStatus.CREATED)
    }

    companion object {
        private const val PARAM_ID = "id"
        private const val PARAM_USER_ID = "userId"
    }

}