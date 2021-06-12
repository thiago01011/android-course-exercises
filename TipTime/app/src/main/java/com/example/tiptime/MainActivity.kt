package com.example.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat.getCurrencyInstance
import kotlin.math.ceil

/*class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}*/
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val cost = binding.editTextCostOfService.text.toString().toDoubleOrNull()

        if (cost == null) {
            binding.textViewResult.text = ""
            return
        }

        val percentage = when(binding.radioGroupTipOptions.checkedRadioButtonId) {
            R.id.radioButton_amazing -> .2
            R.id.radioButton_good -> .18
            else -> .15
        }
        var tip = cost * percentage

        if (binding.switchRoundTip.isChecked) {
            tip = ceil(tip)
        }
        val formattedTip = getCurrencyInstance().format(tip)
        binding.textViewResult.text = getString(R.string.tip_amount, formattedTip)
    }
}
