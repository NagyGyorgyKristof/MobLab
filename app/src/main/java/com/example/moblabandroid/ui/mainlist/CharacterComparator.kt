package com.example.moblabandroid.ui.mainlist

import android.support.v7.util.DiffUtil
import com.example.moblabandroid.model.CharacterX

object CharacterComparator : DiffUtil.ItemCallback<CharacterX>() {

    override fun areItemsTheSame(oldItem: CharacterX, newItem: CharacterX): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterX, newItem: CharacterX): Boolean {
        return oldItem == newItem
    }

}
