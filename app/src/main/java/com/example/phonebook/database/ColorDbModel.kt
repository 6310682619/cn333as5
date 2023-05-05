package com.example.phonebook.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ColorDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "hex") val hex: String,
    @ColumnInfo(name = "name") val name: String
) {
    companion object {
        val DEFAULT_COLORS = listOf(
            ColorDbModel(1, "#FFFFFF", "White"),
            ColorDbModel(2, "#C03630", "Red"),
            ColorDbModel(3, "#765F5D", "Pink"),
            ColorDbModel(4, "#625975", "Purple"),
            ColorDbModel(5, "#2C5880", "Metallic Blue"),
            ColorDbModel(6, "#7AA5E5", "Blue"),
            ColorDbModel(7, "#498f87", "Teal"),
            ColorDbModel(8, "#529C85", "Green"),
            ColorDbModel(9, "#B6DA9C", "Light Green"),
            ColorDbModel(10, "#EDF7B9", "Yellow"),
            ColorDbModel(11, "#E9BD9C", "Orange"),
            ColorDbModel(12, "#EFDEC1", "Cream"),
            ColorDbModel(13, "#765F5D", "Brown"),
            ColorDbModel(14, "#9E9E9E", "Gray")
        )
        val DEFAULT_COLOR = DEFAULT_COLORS[0]
    }
}
