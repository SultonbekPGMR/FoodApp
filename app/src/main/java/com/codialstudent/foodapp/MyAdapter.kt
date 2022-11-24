package com.codialstudent.foodapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.codialstudent.foodapp.databinding.ItemListBinding

class MyAdapter(context: Context, val list: ArrayList<Data>) :
    ArrayAdapter<Data>(context, R.layout.item_list, list) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val itemListBinding =
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        itemListBinding.name.text = list[position].name

        return itemListBinding.root
    }

}