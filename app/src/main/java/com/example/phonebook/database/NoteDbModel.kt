package com.example.phonebook.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "color_id") val colorId: Long,
    @ColumnInfo(name = "in_trash") val isInTrash: Boolean,
    @ColumnInfo(name = "tag_id") val tagId: Long,
) {
    companion object {
        val DEFAULT_NOTES = listOf(
            NoteDbModel(1, "Anudchana", "0888888888", 1, false,1),
        )
    }
}
