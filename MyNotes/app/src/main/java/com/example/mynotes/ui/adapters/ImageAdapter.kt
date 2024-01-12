package com.example.mynotes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.databinding.ItemGridimageBinding
import com.example.mynotes.databinding.ItemNoteBinding
import com.example.mynotes.models.NoteResponse
import com.example.mynotes.models.PokeURL
import com.squareup.picasso.Picasso

class ImageAdapter() :  RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private var pokeURLS: List<PokeURL> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        var binding = ItemGridimageBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val pokeURL = pokeURLS[position]
        pokeURL?.let{
            holder.bind(it,position + 1)
        }
    }

    override fun getItemCount(): Int {
        return pokeURLS.count()
    }

    fun updateList(_pokeURLS: List<PokeURL>){
        pokeURLS = _pokeURLS
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(private val binding: ItemGridimageBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(pokeURL: PokeURL,position:Int){
            binding.pokeTextView.text = pokeURL.name
            with(Picasso.get()) {
                var imageURL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${position}.png"
                load(imageURL).into(binding.pokeManImage)
            }
            binding.root.setOnClickListener {
            }
        }
    }
}