package com.single.code.kotlin.studydemo.modules.login

import android.content.Context
import android.util.Log
import com.single.code.kotlin.studydemo.config.Flag
import com.single.code.kotlin.studydemo.entity.LoginResponse
import com.single.code.kotlin.studydemo.modules.mvp.BasePresenter
import com.single.code.kotlin.studydemo.net.APIResponse

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
class LoginPresenter(mView:ILoginView): BasePresenter<ILoginView, LoginModel>() {
    init {
        view = mView
        model = LoginModel()
    }

    fun login(context:Context,userName:String,password:String){
        model.login(userName,password).subscribe(object: APIResponse<LoginResponse>(context)
        {
            override fun success(data: LoginResponse?) {
                // 成功  data UI
                Log.e(Flag.TAG, "success: $data")
                view.loginSuccess(data)
            }

            override fun failure(errorMsg: String?) {
                // 失败 msg UI
                Log.e(Flag.TAG, "failure: errorMsg:$errorMsg")
                view.loginFailed(errorMsg)
            }

        })

    }
}