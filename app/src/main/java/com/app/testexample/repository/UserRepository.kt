package com.app.testexample.repository

import com.app.testexample.api.UsersService
import javax.inject.Inject

class UserRepository
@Inject constructor(private val usersService: UsersService) {
    suspend fun getAllUsers(page: String) = usersService.getAllUsers(page)
}