package com.app.testexample.api

import com.app.testexample.model.UserList
import com.app.testexample.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {
    @GET(END_POINT)
    suspend fun getAllUsers(@Query("page") lat: String): Response<UserList>
}