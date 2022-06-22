package com.example.fitnesstracker.MVP

import android.content.SharedPreferences
import androidx.navigation.NavController
import com.example.fitnesstracker.DTO.RegisterDTO
import com.example.fitnesstracker.Network.LoginService
import com.example.fitnesstracker.R

class PresenterLogin {

    private var viewLogin: ViewLogin? = null
    private var navController: NavController? = null
    private val loginService = LoginService()

    fun setNavController(contr: NavController){
        this.navController = contr
    }

    fun attachView(viewLogin: ViewLogin){
        this.viewLogin = viewLogin
    }

    fun detachView(){
        this.viewLogin = null
    }

    fun onLoginClicked(login: String, password: String, sharedPrefs: SharedPreferences){
        if(login.isBlank()){
            viewLogin?.showLoginError()
            return
        }

        if(password.isBlank()){
            viewLogin?.showPasswordError()
            return
        }

        loginService.login(login, password, object : LoginService.LoginCallback{
            override fun onSuccess(result: RegisterDTO) {
                sharedPrefs.edit()?.putString("Token", result.token)?.apply()
                navController?.navigate(R.id.action_login_to_activityFragment)
            }

            override fun onError(error: Throwable) {
                viewLogin?.showToast(error.toString())
            }

        })
    }

}