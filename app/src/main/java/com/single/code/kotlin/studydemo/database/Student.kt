package com.single.code.kotlin.studydemo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
//Student表
@Entity
class Student {
    //主键，自动增长
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

    @ColumnInfo(name = "name")//可以加别名，如果加了别名就使用别名名称
    lateinit var name:String
    @ColumnInfo//不指定别名则使用变量名
    var age:Int = 0;
    constructor(name: String,age:Int){
        this.age = age
        this.name = name
    }
}