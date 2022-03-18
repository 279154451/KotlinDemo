package com.single.code.kotlin.study.simple.`object`

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：抽象类
 **/
//Kotlin中抽象类和接口都是public,所以不需要加open
abstract class AbsCar:CarCallBack {
    abstract fun initCar():Boolean
    abstract fun startCar()
}