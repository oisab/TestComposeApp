package com.oisab.testcomposeapp.phonelogin

sealed class PhoneLoginIntents {
    data class AddDigit(val digit: String): PhoneLoginIntents()
    object ShowKeyboard : PhoneLoginIntents()
    object HideKeyboard: PhoneLoginIntents()
    object DeleteDigit: PhoneLoginIntents()
    object HideError: PhoneLoginIntents()
    object NavigateOnPinLogin: PhoneLoginIntents()
}

data class PhoneLoginViewState(
    val phoneNumber: String = "",
    val keyboardVisibility: Boolean = true,
    val isErrorState: Boolean = false,
    val errorMessage: String = "",
)

interface IntentHandler<T> {
    fun obtainIntent(intent: T)
}

//sealed class PhoneLoginState {
//    object Loading : PhoneLoginState()
//    data class Error(val isErrorState: Boolean, val errorMessage: String) : PhoneLoginState()
//    data class Display(val isErrorState: Boolean, val phoneNumber: String) : PhoneLoginState()
//}