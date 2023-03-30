package com.example.viewpagertablayout

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.appbar.DataList
import com.example.appbar.databinding.ItemViewBinding

class CustomRecycleAdapter(val dataList: MutableList<DataList>):RecyclerView.Adapter<CustomRecycleAdapter.CustomViewHolder>() {

    class CustomViewHolder(val binding: ItemViewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CustomViewHolder(itemViewBinding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemViewBinding = holder.binding
        itemViewBinding.tvName.text = dataList.get(position).tvName
        itemViewBinding.tvAge.text = dataList.get(position).tvAge
        itemViewBinding.tvEmail.text = dataList.get(position).tvEmail
        itemViewBinding.ivPicture.setImageResource(dataList.get(position).ivPicture)
        itemViewBinding.root.setOnClickListener {
            Toast.makeText(itemViewBinding.ivPicture.context,"${itemViewBinding.tvName.text}",Toast.LENGTH_SHORT).show()
        }
        itemViewBinding.root.setOnLongClickListener {
            Toast.makeText(itemViewBinding.root.context,"${itemViewBinding.tvName.text}이 삭제되었습니다",Toast.LENGTH_SHORT).show()
            dataList.removeAt(position)
            notifyDataSetChanged()
            true
        }
    }
}