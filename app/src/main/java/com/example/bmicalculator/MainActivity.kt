package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.WeightPicker.minValue = 30
        binding.WeightPicker.maxValue = 150

        binding.HeightPicker.minValue = 100
        binding.HeightPicker.maxValue = 250

binding.WeightPicker.setOnValueChangedListener { numberPicker,i,i2, ->

    calculateBMI()
}



    }

    private fun calculateBMI(){

        val height= binding.HeightPicker.value
        val doubleHeight= height.toDouble()/100

        val weight = binding.WeightPicker.value
        val bmi = weight.toDouble()/(doubleHeight * doubleHeight)

        binding.ResultTv.text = String.format("Your BMI is: %.2f",bmi)
        binding.HealthyBody.text = String.format("Considered:%s", HealthyMessage(bmi))
    }

    private fun HealthyMessage(bmi: Double):String {


        if (bmi < 18.5)
            return "UnderWeight"
        if (bmi < 25.0)
            return "Healthy"
        if (bmi < 30.0)
            return "OverWeight"

        return "Obese"
    }


}

