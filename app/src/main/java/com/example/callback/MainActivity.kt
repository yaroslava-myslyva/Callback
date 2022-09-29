package com.example.callback

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.callback.animals.Animal
import com.example.callback.animals.Dog
import com.example.callback.animals.Goose
import com.example.callback.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Callback {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val animalsList = mutableListOf<Animal>(
            Dog("Rex"),
            Goose("Stepa"),
            Dog("Bobik"),
            Goose("Snezhka")
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = Adapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        adapter.setData(animalsList)
        adapter.setCallback(this)

    }

    override fun onClick(animal: Animal) {
        Toast.makeText(this, animal.voice(), Toast.LENGTH_SHORT).show()
        Log.d("ttt", "activity")
    }


}