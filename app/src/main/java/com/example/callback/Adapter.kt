package com.example.callback

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.callback.animals.Animal
import com.example.callback.animals.Dog
import com.example.callback.animals.Goose

class Adapter(val context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var animalsList: MutableList<Animal> = arrayListOf()
    private lateinit var callback: Callback
    private var backgroundColor: Int? = null

    fun setData(data: MutableList<Animal>) {
        this.animalsList = data
    }

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    inner class ViewHolder(itemView: View, callback: Callback) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView? = itemView.findViewById(R.id.name)

        init {
            textView?.setOnClickListener {
                callback.onItemClicked(
                    animalsList[adapterPosition],
                    this@Adapter.context
                )
            }
            backgroundColor?.let { itemView.setBackgroundColor(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder, parent, false)
        return ViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView?.text = animalsList[position].name
        backgroundColor = when (animalsList[position].isFlying) {
            true -> android.R.color.holo_green_light
            false -> android.R.color.holo_purple
        }
    }

    override fun getItemCount(): Int = animalsList.size
}