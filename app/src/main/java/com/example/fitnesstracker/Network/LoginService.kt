package com.example.fitnesstracker.Network


import com.example.fitnesstracker.Api
import com.example.fitnesstracker.DTO.RegisterDTO
import com.example.fitnesstracker.DTO.UserDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class LoginService {

    private val loginApi = NetworkService().retrofit.create(Api::class.java)

    fun register(
        login:String,
        password:String,
        name:String,
        gender:Int,
        callback:LoginCallback
    ){
        val enqueue = loginApi.register(login, password, name, gender)
            .enqueue(object : Callback<RegisterDTO> {
                override fun onResponse(call: Call<RegisterDTO>, response: Response<RegisterDTO>) {
                    if (response.isSuccessful) response.body()?.let { callback.onSuccess(it) }
                        ?: callback.onError(IOException("Exception"))
                    else callback.onError(IOException("Exception"))
                }

                override fun onFailure(call: Call<RegisterDTO>, t: Throwable) {
                    callback.onError(t)
                }

            })
    }

    fun login(login:String, password:String, callback:LoginCallback){

        loginApi.login(login, password)
            .enqueue(object : Callback<RegisterDTO>{
                override fun onResponse(call: Call<RegisterDTO>, response: Response<RegisterDTO>) {
                    if(response.isSuccessful) response.body()?.let { callback.onSuccess(it) }
                        ?: callback.onError(IOException("Exception"))
                    else callback.onError(IOException("Exception"))
                }

                override fun onFailure(call: Call<RegisterDTO>, t: Throwable) {
                    callback.onError(t)
                }

            })
    }

    fun logout(token: String, callback:LogoutCallback){
        loginApi.logout(token)
            .enqueue(object : Callback<Any>{
                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    if(response.isSuccessful) response.body()?.let { callback.onSuccess() }
                        ?: callback.onError()
                    else callback.onError()
                }

                override fun onFailure(call: Call<Any>, t: Throwable) {
                    callback.onError()
                }

            })
    }

    fun profile(token: String, callback:ProfileCallback){
        loginApi.profile(token)
            .enqueue(object : Callback<UserDTO>{
                override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {
                    if(response.isSuccessful) response.body()?.let { callback.onSuccess(it) }
                        ?: callback.onError(IOException("Exception"))
                    else callback.onError(IOException("Exception"))
                }

                override fun onFailure(call: Call<UserDTO>, t: Throwable) {
                    callback.onError(t)
                }

            })
    }

    interface LogoutCallback{
        fun onSuccess()
        fun onError()
    }

    interface LoginCallback{
        fun onSuccess(result: RegisterDTO)
        fun onError(error: Throwable)
    }

    interface ProfileCallback{
        fun onSuccess(result: UserDTO)
        fun onError(error: Throwable)
    }

}