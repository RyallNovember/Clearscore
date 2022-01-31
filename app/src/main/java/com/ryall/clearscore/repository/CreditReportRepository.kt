package com.ryall.clearscore.repository

import com.ryall.clearscore.api.ApiService

class CreditReportRepository constructor(private val apiService: ApiService) {
    suspend fun getCreditReport() = apiService.getCreditReport()
}