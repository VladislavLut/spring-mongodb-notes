package ua.nure.nosql.notes.repository

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import ua.nure.nosql.notes.entity.Note

interface NoteRepository : MongoRepository<Note, ObjectId> {

    fun findNoteByUserId(userId: ObjectId): List<Note>

}