package com.single.code.kotlin.studydemo.database

import androidx.room.*

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
//数据库的访问入口,增删改查
@Dao
interface StudentDao {
    @Insert
    fun insertStudents(vararg students: Student)//vararg表示可变参数，类似Java中的Student... stus

    @Update
    fun updateStudents(vararg students: Student)//vararg表示可变参数，类似Java中的Student... stus


    @Query("DELETE FROM student")
    fun deleteAllStudents()//删除全部

    @Query("SELECT * FROM student ORDER BY ID DESC")
    fun queryAllStudents():List<Student>//查询全部
    // 根据条件删除
    @Delete
    fun deleteStudents(vararg students: Student)

}