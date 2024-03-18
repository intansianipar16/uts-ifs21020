package com.ifs21020.dinopedia

import DinosaurFamily
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DinosaurAdapter(
    private val context: Context,
    private val dinosaurList: List<DinosaurFamily>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<DinosaurAdapter.DinosaurViewHolder>() {

    inner class DinosaurViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imageView: ImageView = itemView.findViewById(R.id.image_dinosaur)
        val textView: TextView = itemView.findViewById(R.id.text_dinosaur_name)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DinosaurViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_dinosaur, parent, false)
        return DinosaurViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DinosaurViewHolder, position: Int) {
        val currentItem = dinosaurList[position]
        holder.imageView.setImageResource(currentItem.imageResourceId)
        holder.textView.text = currentItem.name
    }

    override fun getItemCount() = dinosaurList.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
