package com.example.phonebook.domain

const val NEW_NOTE_ID = -1L

data class NoteModel(
    val id: Long = NEW_NOTE_ID, // This value is used for new notes
    val name: String = "",
    val number: String = "",
    val color: ColorModel = ColorModel.DEFAULT,
    val tag: TagModel = TagModel.DEFAULT
)