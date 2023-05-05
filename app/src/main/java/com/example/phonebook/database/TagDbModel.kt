package com.example.phonebook.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TagDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "nameTag") val nameTag: String
) {
    companion object {
        val DEFAULT_TAGS = listOf(
            TagDbModel(1, "Mobile"),
            TagDbModel(3, "Work"),
            TagDbModel(2, "Home"),
        )
        val DEFAULT_TAG = DEFAULT_TAGS[0]
    }
}