package ua.nure.nosql.notes.entity

import com.fasterxml.jackson.annotation.JsonGetter
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed

data class Note(
        @Id @Indexed(direction = IndexDirection.ASCENDING)
        var id: ObjectId = ObjectId.get(),
        var title: String = "",
        var text: String = "",
        @Indexed(direction = IndexDirection.ASCENDING)
        var userId: ObjectId = ObjectId.get()
) {
    @JsonGetter("id")
    fun getId(): String = id.toHexString()

    @JsonGetter("userId")
    fun getUserId(): String = userId.toHexString()
}