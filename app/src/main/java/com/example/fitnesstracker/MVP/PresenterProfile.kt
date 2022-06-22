package com.example.fitnesstracker.MVP

import android.content.SharedPreferences
import androidx.navigation.NavController
import com.example.fitnesstracker.DTO.UserDTO
import com.example.fitnesstracker.Network.LoginService
import com.example.fitnesstracker.R


class PresenterProfile {

    private var viewProfile: ViewProfile? = null
    private val loginService = LoginService()

    fun attachView(viewProfile: ViewProfile){
        this.viewProfile = viewProfile
    }

    fun detachView(){
        this.viewProfile = null
    }

    fun onLogoutClicked(token: String){
        loginService.logout("Bearer $token", object : LoginService.LogoutCallback{
            override fun onSuccess() {
            }

            override fun onError() {
            }
        })
    }

    fun onViewCreated(token: String){
        loginService.profile("Bearer $token", object : LoginService.ProfileCallback{
            override fun onSuccess(result: UserDTO) {
                viewProfile?.getData(result.name, result.login)
            }

            override fun onError(error: Throwable) {
                viewProfile?.showToast(error.toString())
            }
        })
    }

    fun deleteToken(sharedPrefs: SharedPreferences, navController: NavController){
        sharedPrefs.edit().remove("Token").apply()
        navController.navigate(R.id.action_activityFragment_to_welcomePage)
    }

}