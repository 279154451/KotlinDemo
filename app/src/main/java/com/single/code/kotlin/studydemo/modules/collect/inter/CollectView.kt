package com.single.code.kotlin.studydemo.modules.collect.inter

import com.single.code.kotlin.studydemo.database.Student

interface CollectView {

    // 显示数据  --- 》 View

    fun showResultSuccess(result: List<Student> ?)

    fun showResult(result: Boolean)
}