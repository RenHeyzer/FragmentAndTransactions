package com.example.fragmentandtransactions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragmentandtransactions.databinding.ItemImageBinding

class ImagesAdapter(
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    private var imageList = mutableListOf<Image>()

    fun setImages(imageList: MutableList<Image>) {
        this.imageList = imageList
        notifyDataSetChanged()
    }

    fun setImage(image: Image) {
        imageList.add(image)
        notifyDataSetChanged()
    }

    fun deleteImage(index: Int) {
        imageList.removeAt(index)
        notifyDataSetChanged()
    }

    fun updateImage(index: Int, image: Image) {
        imageList[index] = image
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onItemClickListener.onItemClick(imageList[adapterPosition])
            }
        }

        fun onBind(image: Image) = with(binding) {
            Glide.with(ivImage.context)
                .load(image.imageUrl)
                .placeholder(R.drawable.placeholder)
                .into(ivImage)

            tvTags.text = image.tags.toString().replace("[", "").replace("]", "")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(imageList[position])
    }

    override fun getItemCount() = imageList.size
}