package com.example.callback

import android.content.Context
import android.widget.Toast
import com.example.callback.animals.Animal

class Callback() {
    fun onItemClicked(animal: Animal, context: Context) {
        Toast.makeText(context, animal.voice(), Toast.LENGTH_SHORT).show()

    }
}