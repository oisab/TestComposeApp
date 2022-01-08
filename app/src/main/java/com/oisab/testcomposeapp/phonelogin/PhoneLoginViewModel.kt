package com.oisab.testcomposeapp.phonelogin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PhoneLoginViewModel : ViewModel(), IntentHandler<PhoneLoginIntents> {
    val phoneLoginViewState: MutableLiveData<PhoneLoginViewState> = MutableLiveData(
        PhoneLoginViewState()
    )

    override fun obtainIntent(intent: PhoneLoginIntents) {
        when (intent) {
            is PhoneLoginIntents.AddDigit -> phoneLoginViewState.postValue(reduce(intent, phoneLoginViewState.value!!))
            PhoneLoginIntents.DeleteDigit -> phoneLoginViewState.postValue(reduce(intent, phoneLoginViewState.value!!))
            PhoneLoginIntents.ShowKeyboard ->  phoneLoginViewState.postValue(reduce(intent, phoneLoginViewState.value!!))
            PhoneLoginIntents.HideKeyboard ->  phoneLoginViewState.postValue(reduce(intent, phoneLoginViewState.value!!))
            PhoneLoginIntents.HideError -> phoneLoginViewState.postValue(reduce(intent, phoneLoginViewState.value!!))
            PhoneLoginIntents.NavigateOnPinLogin -> phoneLoginViewState.postValue(reduce(intent, phoneLoginViewState.value!!))
        }
    }

    private fun reduce(intent: PhoneLoginIntents, currentViewState: PhoneLoginViewState): PhoneLoginViewState {
        return when (intent) {
            is PhoneLoginIntents.AddDigit -> currentViewState
                .copy(phoneNumber = currentViewState.phoneNumber + intent.digit)
            PhoneLoginIntents.DeleteDigit -> currentViewState
                .copy(phoneNumber = currentViewState.phoneNumber.dropLast(1))
            PhoneLoginIntents.ShowKeyboard -> currentViewState.copy(keyboardVisibility = true)
            PhoneLoginIntents.HideKeyboard -> currentViewState.copy(keyboardVisibility = false)
            PhoneLoginIntents.HideError -> currentViewState.copy(isErrorState = false)
            PhoneLoginIntents.NavigateOnPinLogin -> {
                if (validatePhoneNumber(phoneLoginViewState.value!!.phoneNumber))
                    currentViewState.copy(
                        isErrorState = true,
                        errorMessage = "Пожалуйста, убедитесь, что вы правильно ввели номер телефона"
                    )
                else currentViewState
            }
        }
    }

    private fun validatePhoneNumber(value: String) =
        value.matches(Regex("/^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?\$/"))
}