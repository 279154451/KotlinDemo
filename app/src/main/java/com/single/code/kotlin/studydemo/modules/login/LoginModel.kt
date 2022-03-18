package com.single.code.kotlin.studydemo.modules.login

import com.single.code.kotlin.studydemo.api.WanAndroidAPI
import com.single.code.kotlin.studydemo.entity.LoginResponse
import com.single.code.kotlin.studydemo.entity.LoginResponseWrapper
import com.single.code.kotlin.studydemo.modules.mvp.BaseModel
import com.single.code.kotlin.studydemo.net.APIClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
class LoginModel : BaseModel(){
    fun login(userName:String,password:String): Observable<LoginResponseWrapper<LoginResponse>> {
        return APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            // 全部都是RxJava知识了
            .loginAction(userName, password)  // 起点  往下流  ”包装Bean“
            .subscribeOn(Schedulers.io()) // 给上面请求服务器的操作，分配异步线程
            .observeOn(AndroidSchedulers.mainThread()) // 给下面更新UI操作，分配main线程
    }

    override fun init() {
        TODO("Not yet implemented")
    }
}