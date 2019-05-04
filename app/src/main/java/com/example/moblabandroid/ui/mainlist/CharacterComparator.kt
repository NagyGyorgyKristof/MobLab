package com.example.moblabandroid.ui.mainlist

import android.support.v7.util.DiffUtil
import com.example.moblabandroid.model.Result

object CharacterComparator : DiffUtil.ItemCallback<Result>() {

    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }

}
