package com.single.code.kotlin.studydemo

import android.app.Application
import com.single.code.kotlin.studydemo.database.StudentDataBase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        StudentDataBase.init(this)
    }
}

fun main() {
  test1()
}
fun test2(){
    //非阻塞协程，类似守护线程，主线程结束，立马跟着结束，这里会输出 AAA ->CCC->BBB
    GlobalScope.launch {
        Thread.sleep(1000)
        println("CCC")
    }
    println("AAA")
    Thread.sleep(2000)
    println("BBB")
}
fun test1(){
    //非阻塞协程，类似守护线程，主线程结束，立马跟着结束，所以这里只会输出AAA，BBB，
    // 而CCC不会输出，因为BB输出后主线程结束了，而协程还在Sleep
    GlobalScope.launch {
        Thread.sleep(1000)
        println("CCC")
    }
    println("AAA")
    Thread.sleep(200)
    println("BBB")
}
