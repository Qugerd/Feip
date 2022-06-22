package com.example.fitnesstracker.MVP


import android.content.SharedPreferences
import androidx.navigation.NavController
import com.example.fitnesstracker.DTO.RegisterDTO
import com.example.fitnesstracker.Network.LoginService
import com.example.fitnesstracker.R


class PresenterRegistration {


    private var viewRegistration: ViewRegistration? = null
    private var navController: NavController? = null
    private val loginService = LoginService()

    fun setNavController(contr: NavController){
        this.navController = contr
    }

    fun attachView(view: ViewRegistration){
        this.viewRegistration = view
    }

    fun detachView(){
        this.viewRegistration = null
    }

    fun onRegistrationClicked(login: String, password: String, passwordRepeat: String, name: String,
        gender: Int, sharedPrefs: SharedPreferences){

        if(login.isBlank()){
            viewRegistration?.showLoginError()
            return
        }

        if(password.isBlank()){
            viewRegistration?.showPasswordError()
            return
        }

        if(name.isBlank()){
            viewRegistration?.showNameError()
            return
        }

        if (!(gender == 0 || gender == 1 || gender == 2)){
            viewRegistration?.showToast("Выберите пол")
            return
        }

        if(password != passwordRepeat){
            viewRegistration?.showToast("Пароли не совпадают")
        }

        loginService.register(login, password, name, gender, object : LoginService.LoginCallback{
            override fun onSuccess(result: RegisterDTO) {
                sharedPrefs.edit()?.putString("Token", result.token)?.apply()
                navController?.navigate(R.id.action_registrationPage_to_activityFragment)
            }

            override fun onError(error: Throwable) {
                viewRegistration?.showToast(error.toString())
            }
        })
    }
}