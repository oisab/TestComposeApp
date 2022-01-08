package com.oisab.testcomposeapp.phonepayment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oisab.testcomposeapp.R

class MobileOperatorsViewModel: ViewModel() {
    private val _operators: MutableLiveData<List<MobileOperatorModel>> = MutableLiveData(listOf(
        MobileOperatorModel("МТС", R.drawable.ic_mts_512),
        MobileOperatorModel("Мегафон", R.drawable.ic_megafon_512),
        MobileOperatorModel("Beeline", R.drawable.ic_beeline_512),
        MobileOperatorModel("Tele2", R.drawable.ic_tele2_512),
        MobileOperatorModel("Yota", R.drawable.ic_yota_512),
        MobileOperatorModel("Kode Mobile", R.drawable.ic_kode_mobile_512),
        MobileOperatorModel("Ростелеком", R.drawable.ic_rostelecom_512),
        MobileOperatorModel("Тинькофф Мобайл", R.drawable.ic_tinkoff_512),
        MobileOperatorModel("Голден телеком", R.drawable.ic_golden_telecom_512),
        MobileOperatorModel("МТС1", R.drawable.ic_mts_512),
        MobileOperatorModel("Мегафон1", R.drawable.ic_megafon_512),
        MobileOperatorModel("Beeline1", R.drawable.ic_beeline_512),
        MobileOperatorModel("Tele21", R.drawable.ic_tele2_512),
        MobileOperatorModel("Yota1", R.drawable.ic_yota_512),
        MobileOperatorModel("Kode Mobile1", R.drawable.ic_kode_mobile_512),
        MobileOperatorModel("Ростелеком1", R.drawable.ic_rostelecom_512),
        MobileOperatorModel("Тинькофф Мобайл1", R.drawable.ic_tinkoff_512),
        MobileOperatorModel("Голден телеком1", R.drawable.ic_golden_telecom_512)
    ))
    val operators: LiveData<List<MobileOperatorModel>> = _operators
}