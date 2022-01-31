package com.ryall.clearscore.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryall.clearscore.models.CreditReportResponse
import com.ryall.clearscore.repository.CreditReportRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreditReportViewModel
@Inject constructor(private val repository: CreditReportRepository) : ViewModel() {

    private val _resp = MutableLiveData<CreditReportResponse>()
     val creditReportResponse: LiveData<CreditReportResponse>

        get() = _resp

    fun getCreditReport() = viewModelScope.launch {
        repository.getCreditReport().let { response ->
            if (response.isSuccessful) {
                _resp.postValue(response.body())
            } else {
                Log.d("TAG", "getCreditReport Error Response: ${response.message()}")
            }
        }
    }
}