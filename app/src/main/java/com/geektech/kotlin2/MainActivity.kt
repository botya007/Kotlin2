package com.geektech.kotlin2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geektech.kotlin2.databinding.ActivityMainBinding
import com.geektech.kotlin2.extensions.glide
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val url = mutableListOf(
        "https://i.imgur.com/S05ousl.jpeg",
        "https://i.imgur.com/wJ17Wby.png",
        "https://i.imgur.com/lq1w8yC.jpeg",
        "https://i.imgur.com/lW5jpx1.jpeg",
        "https://i.imgur.com/RJcXQEk.jpeg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submit.setOnClickListener {
            if (binding.editText.equals(null)) {
                Toast.makeText(this, "Please, add URL", Toast.LENGTH_SHORT).show()
            } else {
                url.add(binding.editText.text.toString())
            }
        }

        binding.btnRandom.setOnClickListener {
            val randomUrl = Random.nextInt(url.size)
            val randomElement = url[randomUrl]

            binding.imageView.glide(randomElement)
        }
    }
}
