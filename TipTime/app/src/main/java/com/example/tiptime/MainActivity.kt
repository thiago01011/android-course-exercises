package com.example.tiptime

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
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
        binding.editTextCostOfService.setOnKeyListener { view, keycode, _ -> handleKeyEvent(view, keycode) }
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

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }

}
