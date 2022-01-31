package com.ryall.clearscore.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ryall.clearscore.databinding.ActivityCreditReportDetailBinding
import com.ryall.clearscore.util.Constants.Companion.PERCENTAGE
import com.ryall.clearscore.util.Constants.Companion.SCORE_BAND
import com.ryall.clearscore.util.Constants.Companion.STATUS

class CreditReportDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCreditReportDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreditReportDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val status = intent.getStringExtra(STATUS)
        val scoreBand = intent.getStringExtra(SCORE_BAND)
        val percentage = intent.getStringExtra(PERCENTAGE)

        binding.tvMatch.text = status
        binding.tvScoreBand.text = scoreBand
        binding.tvCreditPercentage.text = "$percentage%"
    }
}