package ua.nure.nosql.notes.service

import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.nosql.notes.entity.Note
import ua.nure.nosql.notes.repository.NoteRepository
import ua.nure.nosql.notes.repository.UserRepository

@Service
class NoteService @Autowired constructor(
        private val noteRepository: NoteRepository,
        private val userRepository: UserRepository
) {

    fun insert(note: Note) {
        if (userRepository.existsById(note.userId)) throw RuntimeException("User with such id does not exist.")
        note.id = ObjectId.get()
        noteRepository.save(note)
    }

    fun getAll() = noteRepository.findAll()

    fun getById(id: ObjectId) = noteRepository.findById(id)
            .orElseThrow { RuntimeException("Note with such id does not exist.") }

    fun getByUserId(userId: ObjectId) = noteRepository.findNoteByUserId(userId)

}