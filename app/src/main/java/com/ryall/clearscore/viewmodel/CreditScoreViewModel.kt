package com.ryall.clearscore.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryall.clearscore.models.CreditScoreResponse
import com.ryall.clearscore.repository.CreditScoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreditScoreViewModel
@Inject constructor(private val repository: CreditScoreRepository) : ViewModel() {
    private val _resp = MutableLiveData<CreditScoreResponse>()
    val creditScoreResponse: LiveData<CreditScoreResponse>
        get() = _resp

    fun getCreditScore() = viewModelScope.launch {
        repository.getCreditReport().let { response ->
            if (response.isSuccessful) {
                _resp.postValue(response.body())
            } else {
                Log.d("TAG", "getCreditScore Error Response: ${response.message()}")
            }
        }
    }
}