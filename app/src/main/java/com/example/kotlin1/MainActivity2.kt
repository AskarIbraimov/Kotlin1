package com.example.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin1.databinding.ActivityMain2Binding
import com.example.kotlin1.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etTex1.setText(intent.getStringExtra(MainActivity.KEY))
        binding.btnStart.setOnClickListener {
            if (binding.etTex1.text.isNotEmpty()){
                setResult(RESULT_OK, Intent().putExtra(MainActivity.KEY2,binding.etTex1.text.toString()))
                finish()
            } else{
                Toast.makeText(this,getString(R.string.empty),Toast.LENGTH_SHORT).show()
            }
        }
    }
}