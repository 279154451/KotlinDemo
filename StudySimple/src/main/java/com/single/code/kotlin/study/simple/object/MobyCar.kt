package com.single.code.kotlin.study.simple.`object`

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
class MobyCar:AbsCar() {
    override fun initCar(): Boolean=false

    override fun startCar() {

    }

    override fun onCarStart(): Int =11
}