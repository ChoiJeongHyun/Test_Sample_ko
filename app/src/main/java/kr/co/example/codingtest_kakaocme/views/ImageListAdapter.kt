package kr.co.example.codingtest_kakaocme.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import kr.co.example.codingtest_kakaocme.R
import kr.co.example.codingtest_kakaocme.base.BaseViewHolder
import kr.co.example.codingtest_kakaocme.databinding.ItemImageBinding
import kr.co.example.codingtest_kakaocme.vo.Document

class ImageListAdapter(val vm: MainViewModel) :
    PagedListAdapter<Document, ImageListAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent , false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.vm = vm
        holder.binding.item = getItem(position)
    }

    inner class ItemViewHolder(view: View) : BaseViewHolder<ItemImageBinding>(view)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Document>() {
            override fun areItemsTheSame(oldItem: Document, newItem: Document) =
                oldItem.thumbnailUrl == newItem.thumbnailUrl

            override fun areContentsTheSame(oldItem: Document, newItem: Document) =
                oldItem == newItem
        }
    }


}