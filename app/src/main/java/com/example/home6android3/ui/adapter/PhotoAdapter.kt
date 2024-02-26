package com.example.home6android3.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.home6android3.data.local.room.entity.PhotoEntity
import com.example.home6android3.databinding.ItemBinding

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private var photos = mutableListOf<PhotoEntity>()

    fun setPhotos(photos: List<PhotoEntity>) {
        this.photos.addAll(photos)
        this.photos.distinctBy {
            it.id
        }
        notifyDataSetChanged()
    }

    inner class PhotoViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(photo: PhotoEntity) = with(binding){
            Glide.with(ivPhoto.context)
                .load(photo.url)
                .into(ivPhoto)
            tvTitle.text = photo.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.onBind(photos[position])
    }
}