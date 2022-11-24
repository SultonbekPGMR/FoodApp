package com.codialstudent.foodapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codialstudent.foodapp.databinding.ActivityAddMealBinding
import com.codialstudent.foodapp.utils.MySharedPreference

class AddMeal : AppCompatActivity() {
    private lateinit var binding: ActivityAddMealBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        MySharedPreference.init(this)

        binding.btnSave.setOnClickListener {
            val name = binding.edtName.text.toString()
            val product = binding.edtProduct.text.toString()
            val order = binding.edtOrder.text.toString()
            val list = MySharedPreference.list
            if (name.isNotEmpty()&&product.isNotEmpty()&&order.isNotEmpty()){
                list.add(Data(name,product,order))

                // Save to cache..
                MySharedPreference.list = list


                Toast.makeText(this, "Saqlandi", Toast.LENGTH_SHORT).show()
                binding.edtName.text.clear()
                binding.edtProduct.text.clear()
                binding.edtOrder.text.clear()
            }else{
                Toast.makeText(this, "To'ldiring!!!", Toast.LENGTH_SHORT).show()
            }

        }


    }
}