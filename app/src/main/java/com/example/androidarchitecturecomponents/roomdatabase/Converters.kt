package com.example.androidarchitecturecomponents.roomdatabase

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    @TypeConverter
    fun fromDateToLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(time: Long): Date {
        return Date(time)
    }
}