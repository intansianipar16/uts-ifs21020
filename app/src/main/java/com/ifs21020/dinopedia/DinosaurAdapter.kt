package com.ifs21020.dinopedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DinosaurAdapter(private val detailList: List<String>) : RecyclerView.Adapter<DinosaurAdapter.DetailViewHolder>() {

    inner class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val detailText: TextView = itemView.findViewById(R.id.dinosaur_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_dinosaur, parent, false)
        return DetailViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val currentItem = detailList[position]
        holder.detailText.text = currentItem
    }

    override fun getItemCount() = detailList.size
}
