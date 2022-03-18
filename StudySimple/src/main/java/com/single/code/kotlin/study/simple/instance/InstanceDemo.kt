package com.single.code.kotlin.study.simple.instance

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
fun main() {
    val manager=NetManager.getInstance()

    manager.showName("hahah")
    var instance = NetManager.getManager1()
    instance?.showName("mamanger")
}