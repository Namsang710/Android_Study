package com.example.practice_todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice_todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    private fun initUI() {



    }
}