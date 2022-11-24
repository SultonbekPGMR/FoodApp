package com.codialstudent.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codialstudent.foodapp.databinding.ActivityMainBinding
import com.codialstudent.foodapp.utils.MySharedPreference

class MainActivity : AppCompatActivity() {
    private lateinit var adapter:MyAdapter
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        MySharedPreference.init(this)

        adapter = MyAdapter(this, MySharedPreference.list)
        binding.myListView.adapter = adapter



        binding.myListView.setOnItemClickListener { _, _, i, _ ->
            val intent =Intent(this,ShowInfoActivity::class.java)
            intent.putExtra("list",MySharedPreference.list[i])
            startActivity(intent)


        }



    }
}