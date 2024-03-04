package com.example.oechappfinal.data.network

import com.example.oechappfinal.data.model.GetValidCode.GetValidCodeRequestModel
import com.example.oechappfinal.data.model.GetValidCode.GetValidCodeResponseModel
import com.example.oechappfinal.data.model.SignIn.SignInRequestModel
import com.example.oechappfinal.data.model.SignUp.SignUpRequestModel
import com.example.oechappfinal.data.model.SignUp.SignUpResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("signUp")
    suspend fun SignUp(@Body signUpRequestModel: SignUpRequestModel): SignUpResponseModel

    @POST("signIn")
    suspend fun SignIn(@Body signInRequestModel: SignInRequestModel): SignUpResponseModel

    @POST("getValidCode")
    suspend fun getValidCode(@Body getValidCodeRequestModel: GetValidCodeRequestModel): GetValidCodeResponseModel
}