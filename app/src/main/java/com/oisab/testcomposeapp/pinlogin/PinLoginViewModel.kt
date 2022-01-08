package com.oisab.testcomposeapp.pinlogin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PinLoginViewModel : ViewModel() {
    private val _password: MutableLiveData<String> = MutableLiveData("")
    var password: LiveData<String> = _password
    fun setPassword(newValue: String) {
        _password.postValue(newValue)
        password = _password
    }

    private val _isErrorState: MutableLiveData<Boolean> = MutableLiveData(false)
    var isErrorState: LiveData<Boolean> = _isErrorState
    fun setErrorState(value: Boolean) {
        _isErrorState.postValue(value)
        isErrorState = _isErrorState
    }

    fun validatePassword(value: String) = value.matches(
        Regex(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,32}$"
        )
    )
}