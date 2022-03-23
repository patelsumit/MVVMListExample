package com.app.testexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.testexample.databinding.RowItemBinding
import com.app.testexample.model.Data
import com.squareup.picasso.Picasso

class UserAdapter : ListAdapter<Data, UserAdapter.ItemsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            RowItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val dataList = getItem(position)
        holder.bind(dataList)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class ItemsViewHolder(private val binding: RowItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data) {
            binding.txtDescription.text = data.first_name + data.last_name
            binding.txtEmail.text = data.email
            Picasso.get()
                .load(data.avatar)
                .into(binding.imageView);
        }
    }
}
