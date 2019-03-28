package com.example.moblabandroid.ui.mainlist

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import com.example.moblabandroid.R
import com.example.moblabandroid.model.ModelContent.RnMItem
import com.example.moblabandroid.ui.details.ItemDetailActivity
import kotlinx.android.synthetic.main.item_list_content.view.*

//TODO review
class MainListRecyclerViewAdapter(
    private val values: List<RnMItem>
) : RecyclerView.Adapter<MainListRecyclerViewAdapter.ViewHolder>() {

    private val onClickListener: OnClickListener

    // TODO move into hte viewholder
    init {
        onClickListener = OnClickListener { v ->
            val item = v.tag as RnMItem


            val intent = Intent(v.context, ItemDetailActivity::class.java).apply {
                putExtra(ItemDetailActivity.ARG_ITEM_ID, item.id)
            }
            v.context.startActivity(intent)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content

        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val idView: TextView = view.id_text
        val contentView: TextView = view.content
    }
}