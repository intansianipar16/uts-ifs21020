package com.ifs21020.dinopedia

import Dinosaur
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21020.dinopedia.databinding.ItemDinosaurBinding

class DinosaurAdapter(private val listDino: ArrayList<Dinosaur>) :
    RecyclerView.Adapter<DinosaurAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback:  OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemDinosaurBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val dino = listDino[position]
        holder.binding.ivItemImage.setImageResource(dino.dinos_image)
        holder.binding.s.text = dino.dinos_name
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listDino[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listDino.size
    class ListViewHolder(var binding: ItemDinosaurBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: Dinosaur)

    }

}