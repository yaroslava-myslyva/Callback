package com.example.callback

import android.content.Context
import android.widget.Toast
import com.example.callback.animals.Animal

interface Callback {
    fun onClick(animal: Animal) {
    }
}