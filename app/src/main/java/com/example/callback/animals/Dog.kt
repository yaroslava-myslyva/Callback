package com.example.callback.animals

class Dog(override val name: String) : Animal {
    override val isFlying: Boolean = false
    override fun voice() {
        TODO("Not yet implemented")
    }
}