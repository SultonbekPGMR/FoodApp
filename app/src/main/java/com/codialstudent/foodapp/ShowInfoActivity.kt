package com.codialstudent.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.codialstudent.foodapp.databinding.ActivityShowInfoBinding

class ShowInfoActivity : AppCompatActivity() {
    private lateinit var binding:ActivityShowInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityShowInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list:Data = intent.getSerializableExtra("list") as Data
        supportActionBar?.title = list.name.uppercase()
        binding.tvProduct.text = list.products
        binding.tvOrder.text = list.order



    }
}