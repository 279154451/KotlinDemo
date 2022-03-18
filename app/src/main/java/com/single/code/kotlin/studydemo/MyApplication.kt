package com.single.code.kotlin.studydemo

import android.app.Application
import com.single.code.kotlin.studydemo.database.StudentDataBase

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        StudentDataBase.init(this)
    }
}