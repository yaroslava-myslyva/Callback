package com.example.callback.animals

class Dog(override val name: String) : Animal {
    override val isFlying: Boolean = false
    override fun voice() :String{
        return "Gav-gav"
    }
}