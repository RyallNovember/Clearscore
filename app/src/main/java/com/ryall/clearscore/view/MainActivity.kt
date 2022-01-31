package com.ryall.clearscore.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ryall.clearscore.R
import com.ryall.clearscore.databinding.ActivityMainBinding
import com.ryall.clearscore.util.Constants.Companion.PERCENTAGE
import com.ryall.clearscore.util.Constants.Companion.SCORE_BAND
import com.ryall.clearscore.util.Constants.Companion.STATUS
import com.ryall.clearscore.viewmodel.CreditReportViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CreditReportViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCreditReport()
    }

    private fun getCreditReport() {
        viewModel.getCreditReport()
        viewModel.creditReportResponse.observe(this, { response ->
            val creditScoreAmount = response.creditReportInfo.score
            val report = response.creditReportInfo

            binding.tvScore.text = creditScoreAmount.toString()

            binding.donutView.apply {
                cap = response.creditReportInfo.maxScoreValue.toFloat()
                addAmount(
                    "Credit Score",
                    creditScoreAmount.toFloat(),
                    ContextCompat.getColor(context, R.color.green)
                )
                setOnClickListener {
                    val intent = Intent(context, CreditReportDetailActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString(STATUS,report.status)
                    bundle.putString(SCORE_BAND,report.equifaxScoreBandDescription)
                    bundle.putString(PERCENTAGE,report.percentageCreditUsed.toString())
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            }
        })
    }
}