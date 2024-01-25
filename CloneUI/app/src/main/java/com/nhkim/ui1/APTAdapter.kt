package com.nhkim.ui1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhkim.ui1.databinding.HomeRecyclerViewItemBinding

class APTAdapter(val apt: MutableList<APT>) : RecyclerView.Adapter<APTAdapter.Holder>() {

//    interface ItemClick{
//        fun onClick(view: View, position: Int)
//        fun onLongClick(view: View, position: Int): Boolean
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): APTAdapter.Holder {
        val binding = HomeRecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: APTAdapter.Holder, position: Int) {
        val item = apt[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = apt.size

    // 데이터 삭제
    fun removeItem(position: Int) {
        apt.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, apt.size)
    }
    inner class Holder(binding: HomeRecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val image = binding.room1
        private val monthlyRent = binding.tvPrice
        private val roomType = binding.tvRoomType
        private val description = binding.tvDescription
        fun bind(apt: APT){
            image.setImageResource(apt.image)
            monthlyRent.text = apt.monthlyRent
            roomType.text = apt.roomType
            description.text = apt.description

            image.clipToOutline = true
        }
    }
}