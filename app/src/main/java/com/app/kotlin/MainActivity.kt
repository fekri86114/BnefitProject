package com.app.kotlin

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.kotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.resultButton.setOnClickListener {
            if (binding.rulesCheckBox.isChecked) {
                if (binding.priceEditText.text.toString() == "" ||
                    binding.numberMonthEditText.text.toString() == "" ||
                    binding.benefitEditText.text.toString() == ""){
                    Toast.makeText(this, "تمامی مقادیر باید پر شوند", Toast.LENGTH_SHORT).show()

                }else{
                    val price: Double = binding.priceEditText.text.toString().toDouble()
                    val numberOfDay: Double = binding.numberMonthEditText.text.toString().toDouble() * 30
                    val benefit: Double = binding.benefitEditText.text.toString().toDouble()
                    val result : Double = (price * numberOfDay * benefit) / 36500.0
                    binding.showResultTextView.text = result.toString()
                    binding.showResultTextView.visibility = View.VISIBLE

                    Toast.makeText(this, "سود محاسبه شد", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "لطفا قوانین را تایید کنید", Toast.LENGTH_SHORT).show()
            }
        }
    }
}