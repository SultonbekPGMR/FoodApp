package com.codialstudent.foodapp.utils

import android.content.Context
import android.content.SharedPreferences
import com.codialstudent.foodapp.Data
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object MySharedPreference {
    private const val NAME = "cache_file"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }


    var list: ArrayList<Data>
        get() = gsonStringToArraylist(preferences.getString("keyList", "[]")!!)
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("keyList", arrayListToGsonString(value))
            }
        }


    private fun arrayListToGsonString(list: ArrayList<Data>): String {
        val gson = Gson()
        return gson.toJson(list)
    }


    private fun gsonStringToArraylist(str: String): ArrayList<Data> {
        val gson = Gson()

        val type = object : TypeToken<ArrayList<Data>>() {}.type
        return gson.fromJson(str, type)


    }


}