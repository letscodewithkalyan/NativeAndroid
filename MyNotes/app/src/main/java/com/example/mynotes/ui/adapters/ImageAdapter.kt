package com.example.mynotes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.databinding.ItemGridimageBinding
import com.example.mynotes.databinding.ItemNoteBinding
import com.example.mynotes.models.PokeURL

class ImageAdapter(private val pokeURLS: List<PokeURL>) :  RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        var binding = ItemGridimageBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return pokeURLS.count()
    }

    inner class ImageViewHolder(private val binding: ItemGridimageBinding):RecyclerView.ViewHolder(binding.root){
    }
}