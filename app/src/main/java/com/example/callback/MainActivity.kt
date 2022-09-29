package com.example.callback

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.callback.animals.Animal
import com.example.callback.animals.Dog
import com.example.callback.animals.Goose
import com.example.callback.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val callback = Callback()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val animalsList = mutableListOf<Animal>(
            Dog("Mucha"),
            Goose("Stepa"),
            Dog("Bobik"),
            Goose("Snezhka")
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = Adapter(this)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        adapter.setData(animalsList)
        adapter.setCallback(callback)

    }
}