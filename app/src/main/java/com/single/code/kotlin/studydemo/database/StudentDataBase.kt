package com.single.code.kotlin.studydemo.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
@Database(entities = [Student::class],version = 1)
abstract class StudentDataBase :RoomDatabase(){
    abstract fun getDao():StudentDao
    companion object{
        private lateinit var context:Context
        fun init(application: Application){
            context = application
        }
        private var INSTANCE:StudentDataBase? = null
        fun getDataBase():StudentDataBase?{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context,StudentDataBase::class.java,"DBName.db")
                    .allowMainThreadQueries()//允许在主线程运行
                    .build()
            }
            return INSTANCE
        }
    }
}