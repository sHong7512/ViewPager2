package com.shong.viewpager2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ExampleAdapter internal constructor(val context: Context) :
    RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {
    val TAG = this::class.java.simpleName

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val examples = listOf(0, 1, 2, 3, 4)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exampleTextView: TextView = itemView.findViewById(R.id.exampleTextView)
        val exampleLayout: ConstraintLayout = itemView.findViewById(R.id.exampleLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
        val itemView = inflater.inflate(R.layout.item_example, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.apply {
            exampleTextView.text = "$position"
            when(position){
                0 -> {
                    exampleLayout.setBackgroundColor(Color.parseColor("#FF0000"))
                }
                1 -> {
                    exampleLayout.setBackgroundColor(Color.parseColor("#FFFF00"))
                }
                2 -> {
                    exampleLayout.setBackgroundColor(Color.parseColor("#00FF00"))
                }
                3 -> {
                    exampleLayout.setBackgroundColor(Color.parseColor("#00FFFF"))
                }
                4 -> {
                    exampleLayout.setBackgroundColor(Color.parseColor("#0000FF"))
                }
            }

        }
    }

    override fun getItemCount() = examples.size

}