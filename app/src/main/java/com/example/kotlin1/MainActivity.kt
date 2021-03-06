package com.example.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var registerActivity: ActivityResultLauncher<Intent>

    companion object {
        const val KEY = "text"
        const val KEY2 = "text2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){activityResult ->
            binding.etTex1.setText(activityResult.data?.getStringExtra(KEY2))
        }

        binding.btnStart.setOnClickListener {
            if (binding.etTex1.text.toString().isNotEmpty()) {
                Intent(this@MainActivity, MainActivity2::class.java).apply {
                    putExtra(KEY, binding.etTex1.text.toString())
                    registerActivity.launch(this)
                }
            } else {
                Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_SHORT).show()
            }
        }
    }
}