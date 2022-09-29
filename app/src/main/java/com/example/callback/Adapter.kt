package com.example.callback

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.callback.animals.Animal
import java.lang.Exception

class Adapter(val context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var animalsList: MutableList<Animal> = arrayListOf()
    private lateinit var callback: Callback


    fun setData(data: MutableList<Animal>) {
        this.animalsList = data
    }

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    inner class ViewHolder(itemView: View, callback: Callback, type: Int) :
        RecyclerView.ViewHolder(itemView) {
        val textView: TextView? = itemView.findViewById(R.id.name)

        init {
            val backgroundColor = when (type) {
                1 -> android.R.color.holo_green_light
                0 -> android.R.color.holo_purple
                else -> throw Exception("Wrong view type")
            }

            itemView.setBackgroundResource(backgroundColor)

            itemView.setOnClickListener {
                callback.onItemClicked(
                    animalsList[adapterPosition],
                    this@Adapter.context
                )
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder, parent, false)

        return ViewHolder(view, callback, viewType)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView?.text = animalsList[position].name

    }

    override fun getItemCount(): Int = animalsList.size

    override fun getItemViewType(position: Int): Int {
        return if (animalsList[position].isFlying) 1 else 0
    }
}