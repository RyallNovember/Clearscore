package com.ryall.clearscore.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ryall.clearscore.R
import com.ryall.clearscore.databinding.ActivityMainBinding
import com.ryall.clearscore.viewmodel.CreditScoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CreditScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCreditScore()
    }

    private fun getCreditScore() {
        viewModel.getCreditScore()
        viewModel.creditScoreResponse.observe(this, { response ->
            var creditScoreAmount = response.creditReportInfo.score
            binding.tvScore.text = creditScoreAmount.toString()
           // binding.donutView.setAmount("", creditScoreAmount.toFloat())
            binding.donutView.apply {
                cap =700f
                addAmount(
                    "Ryall,",creditScoreAmount.toFloat(), resources.getColor(R.color.green)
                )
            }
        })
    }
}