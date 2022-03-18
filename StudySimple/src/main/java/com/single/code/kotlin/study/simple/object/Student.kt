package com.single.code.kotlin.study.simple.`object`

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
class Student(id:Int) : Person(id) {
    /*
     *Java中成员有默认值，但是方法内部没有默认值
     *Kotlin中成员变量全部都是没有默认值的,所以需要初始化（要么用lateinit进行懒加载）
     */
    lateinit var name:String//lateinit懒加载如果后面没有赋值会报错
    var  sexe :String? = null//需要初始化,?表示对象可以为空，没有？表示对象不能为null
}