package com.example.moblabandroid.ui.mainlist

import android.content.Context
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.moblabandroid.R
import com.example.moblabandroid.model.Result
import com.example.moblabandroid.ui.mainlist.CharacterAdapter.CharacterViewHolder
import kotlinx.android.synthetic.main.row_character.view.*

class CharacterAdapter(val context: Context) : ListAdapter<Result, CharacterViewHolder>(CharacterComparator) {

    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val characterImage = itemView.characterImage
        private val nameText = itemView.characterNameText
        private val statusText = itemView.characterStatusText
        private val speciesTExt = itemView.characterSpeciesText

        private var characterItem: Result? = null

        init {
            itemView.setOnClickListener {
                characterItem?.let { listener?.onCharacterClicked(it) }
            }
        }

        fun bind(character: Result) {
            characterItem = character

            Glide.with(context).load(characterItem!!.image).into(characterImage)
            nameText.text = character.name
            statusText.text = character.status
            speciesTExt.text = character.species
        }
    }

    interface Listener {
        fun onCharacterClicked(character: Result)
    }
}
