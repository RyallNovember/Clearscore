package com.ryall.clearscore.models

data class CreditScoreResponse(
    val accountIDVStatus: String,
    val augmentedCreditScore: Any,
    val coachingSummary: CoachingSummary,
    val creditReportInfo: CreditReportInfo,
    val dashboardStatus: String,
    val personaType: String
)