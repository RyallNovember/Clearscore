package com.ryall.clearscore.api


import com.ryall.clearscore.models.CreditScoreResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/endpoint.json")
    suspend fun getCreditScore() : Response<CreditScoreResponse>
}