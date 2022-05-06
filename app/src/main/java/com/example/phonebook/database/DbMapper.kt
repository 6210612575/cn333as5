package com.example.phonebook.database

import com.example.phonebook.domain.ColorModel
import com.example.phonebook.domain.NEW_NOTE_ID
import com.example.phonebook.domain.NoteModel
import com.example.phonebook.domain.TagModel


class DbMapper {
    fun mapNotes(
        noteDbModels: List<NoteDbModel>,
        colorDbModels: Map<Long, ColorDbModel>,
        tagDbModels: Map<Long,TagDbModel>
    ): List<NoteModel> = noteDbModels.map {
        val colorDbModel = colorDbModels[it.colorId]
            ?: throw RuntimeException("Color for colorId: ${it.colorId} was not found. Make sure that all colors are passed to this method")
        val tagDbModel = tagDbModels[it.tagId]
            ?: throw RuntimeException("Tag for tagId: ${it.tagId} was not found. Make sure that all colors are passed to this method")
        mapNote(it, colorDbModel,tagDbModel)
    }
    fun mapNote(noteDbModel: NoteDbModel, colorDbModel: ColorDbModel,tagDbModel: TagDbModel): NoteModel {
        val color = mapColor(colorDbModel)
        val tag = mapTag(tagDbModel)
        return with(noteDbModel) { NoteModel(id, title, content,color,tag) }
    }

    fun mapColors(colorDbModels: List<ColorDbModel>): List<ColorModel> =
        colorDbModels.map { mapColor(it) }

    fun mapColor(colorDbModel: ColorDbModel): ColorModel =
        with(colorDbModel) { ColorModel(id, name, hex) }

    fun mapTags(tagDbModels: List<TagDbModel>): List<TagModel> =
        tagDbModels.map { mapTag(it) }

    fun mapTag(tagDbModel: TagDbModel): TagModel =
        with(tagDbModel) { TagModel(id, name) }

    fun mapDbNote(note: NoteModel): NoteDbModel =
        with(note) {

            if (id == NEW_NOTE_ID)
                NoteDbModel(
                    title = name,
                    content = number,
                    colorId = color.id,
                    isInTrash = false,
                    tagId = tag.id
                )
            else
                NoteDbModel(id, name, number, color.id, false,tag.id)
        }
}