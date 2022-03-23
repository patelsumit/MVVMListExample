package com.app.testexample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.testexample.model.UserList
import com.app.testexample.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel
@Inject constructor(private val repository: UserRepository) : ViewModel() {

    private val _response = MutableLiveData<UserList>()

    val responseImages: LiveData<UserList> get() = _response

    init {
        getAllImages()
    }

    private fun getAllImages() = viewModelScope.launch {

        repository.getAllUsers("2").let { response ->
            if (response.isSuccessful) {
                Log.e("your tag",
                    "Is Success : ${response.body()}")
                _response.postValue(response.body())
            }else{
                Log.d("your tag",
                    "Users Error: ${response.errorBody()}")
            }
        }
    }
}

