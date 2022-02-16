package com.shong.viewpager2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.shong.viewpager2.databinding.ItemExampleBinding

class ExampleAdapter internal constructor() :
    RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {
    val TAG = this::class.java.simpleName

    private val examples = listOf(0, 1, 2, 3, 4, 5)

    inner class ViewHolder(private val binding: ItemExampleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val color = when(position){
                0 -> Color.parseColor("#FF0000")
                1 -> Color.parseColor("#FFFF00")
                2 -> Color.parseColor("#00FF00")
                3 -> Color.parseColor("#00FFFF")
                4 -> Color.parseColor("#0000FF")
                5 -> Color.parseColor("#FF00FF")
                else -> Color.parseColor("#000000")
            }
            binding.exampleLayout.setBackgroundColor(color)
            binding.exampleTextView.text = "$position"
            showLog(position)
        }
        private fun showLog(position: Int){
            Log.d(TAG,"$position : ${examples[position]}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemExampleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = examples.size

}