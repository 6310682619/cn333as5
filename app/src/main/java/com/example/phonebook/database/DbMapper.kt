package com.example.phonebook.database

import com.example.phonebook.domain.model.ColorModel
import com.example.phonebook.domain.model.NEW_PHONE_ID
import com.example.phonebook.domain.model.PhoneModel
import com.example.phonebook.domain.model.TagModel

class DbMapper {
    fun mapPhones(
        phoneDbModels: List<PhoneDbModel>,
        colorDbModels: Map<Long, ColorDbModel>,
        tagDbModels: Map<Long, TagDbModel>
    ): List<PhoneModel> = phoneDbModels.map {
        val colorDbModel = colorDbModels[it.colorId]
            ?: throw RuntimeException("Color for colorId: ${it.colorId} was not found. Make sure that all colors are passed to this method")
        val tagDbModel = tagDbModels[it.tagId]
            ?: throw RuntimeException("Color for colorId: ${it.tagId} was not found.")
        mapPhone(it, colorDbModel, tagDbModel)
    }

    fun mapPhone(phoneDbModel: PhoneDbModel, colorDbModel: ColorDbModel, tagDbModel: TagDbModel): PhoneModel {
        val color = mapColor(colorDbModel)
        val tag = mapTag(tagDbModel)
        return with(phoneDbModel) { PhoneModel(id, title, content, color, tag) }
    }

    fun mapColors(colorDbModels: List<ColorDbModel>): List<ColorModel> =
        colorDbModels.map { mapColor(it) }

    fun mapColor(colorDbModel: ColorDbModel): ColorModel =
        with(colorDbModel) { ColorModel(id, name, hex) }

    fun mapTags(tagDbModels: List<TagDbModel>): List<TagModel> =
        tagDbModels.map { mapTag(it) }

    fun mapTag(tagDbModel: TagDbModel): TagModel =
        with(tagDbModel) { TagModel(id, nameTag) }

    fun mapDbPhone(phone: PhoneModel): PhoneDbModel =
        with(phone) {
            if (id == NEW_PHONE_ID)
                PhoneDbModel(
                    title = title,
                    content = content,
                    colorId = color.id,
                    tagId = tag.id,
                    isInTrash = false
                )
            else
                PhoneDbModel(id, title, content, color.id, tag.id,false)
        }
}