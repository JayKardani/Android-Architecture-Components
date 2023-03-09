package com.example.androidarchitecturecomponents.listadapteranddiffutilItemcallback

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidarchitecturecomponents.R

class ProgrammingAdapter :
    ListAdapter<ProgrammingItem, ProgrammingAdapter.ProgrammingItemViewHolder>(
        ProgrammingItemDiffUtil()
    ) {

    class ProgrammingItemDiffUtil : DiffUtil.ItemCallback<ProgrammingItem>() {
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    class ProgrammingItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.name)
        private val initial: TextView = view.findViewById(R.id.initial)

        fun bind(item: ProgrammingItem) {
            name.text = item.name
            initial.text = item.initial
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingItemViewHolder {
        return ProgrammingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProgrammingItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}