package com.example.androidarchitecturecomponents

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.androidarchitecturecomponents.mvvm.Quote
import com.example.androidarchitecturecomponents.mvvm.QuoteDAO
import com.example.androidarchitecturecomponents.roomdatabase.Contact
import com.example.androidarchitecturecomponents.roomdatabase.ContactDAO
import com.example.androidarchitecturecomponents.roomdatabase.Converters

@Database(
    entities = [Contact::class, Quote::class],
    version = 2
)
@TypeConverters(Converters::class)
abstract class MainRoomDatabase : RoomDatabase() {

    abstract fun contactDAO(): ContactDAO
    abstract fun quoteDAO(): QuoteDAO

    companion object {

        private val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }

        @Volatile
        private var INSTANCE: MainRoomDatabase? = null

        fun getDatabase(context: Context): MainRoomDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        MainRoomDatabase::class.java,
                        "MainRoomDb"
                    )
//                        .createFromAsset("quotes.bd")
                        .addMigrations(migration_1_2)
                        .build()
                }
            }
            return INSTANCE!!
        }
    }

}