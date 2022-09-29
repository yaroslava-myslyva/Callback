package com.example.callback.animals

class Goose(override val name: String)  :Animal {
    override val isFlying: Boolean = true

    override fun voice() :String{
        return "Ga-ga"
    }
}
