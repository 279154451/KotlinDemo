package com.single.code.kotlin.study.simple.generic

/**
 * 创建时间：2022/3/19
 * 创建人：singleCode
 * 功能描述：
 **/
val fuclazz = Person()
val ziClazz = Student()
fun main() {
    val list1:MutableList<Person> = ArrayList<Person>()
    list1.add(ziClazz)
    testOut(list1)
    val list2:MutableList<Student> = ArrayList<Student>()
    list2.add(ziClazz)
    testIn(list2)
}
//in == ? super Kotlin 中的in就等于Java中的？super 只能修改，不能取
fun testIn(list:  MutableList<in Student>){
    list.add(ziClazz)
    for (any in list) {//但是这里还是能修改，就比较奇怪
        println("testIN")
    }
}
//out == ? extends Kotlin 中的out就等于Java中的？extends,只能取不能修改
fun testOut(list:MutableList<out Person>){
    for (person in list) {
        println("testOut")
    }
//    list.add(fuclazz)//不能修改
//    list.add(ziClazz)
}

