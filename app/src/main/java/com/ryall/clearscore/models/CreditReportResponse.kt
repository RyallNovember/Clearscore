package com.ryall.clearscore.models

import java.io.Serializable

data class CreditReportResponse(
    val accountIDVStatus: String,
    val augmentedCreditScore: Any,
    val coachingSummary: CoachingSummary,
    val creditReportInfo: CreditReportInfo,
    val dashboardStatus: String,
    val personaType: String
) : Serializable