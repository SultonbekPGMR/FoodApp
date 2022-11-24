package com.codialstudent.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codialstudent.foodapp.databinding.ActivityEntryAcitivityBinding

class EntryActivity : AppCompatActivity() {
    private lateinit var binding:ActivityEntryAcitivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntryAcitivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.btnMenu.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnTaomQoshish.setOnClickListener {
            val intent = Intent(this,AddMeal::class.java)
            startActivity(intent)
        }

    }
}