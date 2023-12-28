package com.example.mynotes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.databinding.ItemNoteBinding
import com.example.mynotes.models.NoteResponse

class NoteAdapter(private val onNoteClicked: (NoteResponse) -> Unit) : ListAdapter<NoteResponse, NoteAdapter.NoteViewHolder>(
    ComparatorDiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = getItem(position)
        note?.let{
            holder.bind(it)
        }
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(note: NoteResponse){
            binding.titleTextView.text = note.title
            binding.descriptionTextView.text = note.description
            binding.root.setOnClickListener {
                onNoteClicked(note)
            }
        }
    }

    class ComparatorDiffUtil : DiffUtil.ItemCallback<NoteResponse>(){
        override fun areItemsTheSame(oldItem: NoteResponse, newItem: NoteResponse): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: NoteResponse, newItem: NoteResponse): Boolean {
            return oldItem == newItem
        }
    }
}