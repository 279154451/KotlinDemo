package com.single.code.kotlin.studydemo.modules.login

import com.single.code.kotlin.studydemo.entity.LoginResponse
import com.single.code.kotlin.studydemo.modules.mvp.IBaseView

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
interface ILoginView :IBaseView{
    fun loginSuccess(data: LoginResponse?)
    fun loginFailed(msg:String?)
}