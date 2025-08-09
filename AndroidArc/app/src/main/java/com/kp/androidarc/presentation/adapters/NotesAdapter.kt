package com.kp.androidarc.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kp.androidarc.data.models.NoteModel
import com.kp.androidarc.databinding.ListNotesBinding

class NotesAdapter(private val onItemClick:  (NoteModel) -> Unit) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    var noteList: List<NoteModel> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): NotesViewHolder {
        var binding = ListNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NotesViewHolder,
        position: Int,
    ) {
        var currentItem = noteList[position]
        currentItem?.let { it ->
            holder.bind(it);
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun updateList(notes: List<NoteModel>){
        noteList = notes
        notifyDataSetChanged()
    }

    inner class NotesViewHolder(private val binding: ListNotesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(noteModel: NoteModel){
            binding.titleText.text = noteModel.title;
            binding.descriptionText.text = noteModel.description
            binding.rootCard.setOnClickListener {
                onItemClick(noteModel)
            }
        }
    }
}