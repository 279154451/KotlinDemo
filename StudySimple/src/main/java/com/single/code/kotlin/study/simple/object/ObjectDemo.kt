package com.single.code.kotlin.study.simple.`object`

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
fun main(){
    val person1 = Person(32)//主构造
    val person = Person()//次构造
    val person2 = Person(32,"test")//次构造
    val person3 = Person(32,false)//次构造

    val bean = JavaBean(1,"test",true)
    var(mId,mName,mSex)=bean.copy()
    println("mId=$mId，mName=$mName,mSex=$mSex")
    var(_,mName2,_)=bean.copy()//_表示拒绝接收copy值
    println("mName2=$mName2")
}

