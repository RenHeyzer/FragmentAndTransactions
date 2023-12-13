package com.example.fragmentandtransactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentandtransactions.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), OnItemClickListener {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!
    private val imageList = mutableListOf<Image>()
    private val imagesAdapter = ImagesAdapter(this)

    override fun onItemClick(image: Image) {
        val bundle = Bundle().apply {
            putSerializable(IMAGE_KEY, image)
        }
        parentFragmentManager.beginTransaction()
            .add(R.id.fragment_container, SecondFragment::class.java, bundle)
            .addToBackStack(FirstFragment::class.simpleName)
            .commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        fillImages()
        scrollDown()
    }

    private fun setupRecyclerView() {
        binding.rvImages.adapter = imagesAdapter
    }

    private fun fillImages() {
        imageList.apply {
            add(
                Image(
                    imageUrl = "https://p4.wallpaperbetter.com/wallpaper/872/428/30/download-nature-for-pc-1920x1080-wallpaper-preview.jpg",
                    tags = listOf("descargar nature para pc 1920x1080", "Fondo de pantalla HD")
                )
            )
            add(
                Image(
                    imageUrl = "https://p4.wallpaperbetter.com/wallpaper/540/639/581/download-nature-for-pc-1920x1080-wallpaper-preview.jpg",
                    tags = listOf("descargar nature para pc 1920x1080", "Fondo de pantalla HD")
                )
            )
            add(
                Image(
                    imageUrl = "https://p4.wallpaperbetter.com/wallpaper/896/100/974/download-nature-for-pc-1920x1080-wallpaper-preview.jpg",
                    tags = listOf("descargar nature para pc 1920x1080", "Fondo de pantalla HD")
                )
            )
            add(
                Image(
                    imageUrl = "https://p4.wallpaperbetter.com/wallpaper/211/841/142/download-nature-for-pc-1920x1080-wallpaper-preview.jpg",
                    tags = listOf("fd;aksdjfasjd;fj", "dlsjfkdkjflsdjfiowe")
                )
            )
            add(
                Image(
                    imageUrl = "https://p4.wallpaperbetter.com/wallpaper/872/428/30/download-nature-for-pc-1920x1080-wallpaper-preview.jpg",
                    tags = listOf("descargar nature para pc 1920x1080", "Fondo de pantalla HD")
                )
            )
            add(
                Image(
                    imageUrl = "https://p4.wallpaperbetter.com/wallpaper/872/428/30/download-nature-for-pc-1920x1080-wallpaper-preview.jpg",
                    tags = listOf("descargar nature para pc 1920x1080", "Fondo de pantalla HD")
                )
            )
            add(
                Image(
                    imageUrl = "https://p4.wallpaperbetter.com/wallpaper/872/428/30/download-nature-for-pc-1920x1080-wallpaper-preview.jpg",
                    tags = listOf("descargar nature para pc 1920x1080", "Fondo de pantalla HD")
                )
            )
            add(
                Image(
                    imageUrl = "https://p4.wallpaperbetter.com/wallpaper/872/428/30/download-nature-for-pc-1920x1080-wallpaper-preview.jpg",
                    tags = listOf("descargar nature para pc 1920x1080", "Fondo de pantalla HD")
                )
            )
        }
        imagesAdapter.setImages(imageList)
    }

    private fun scrollDown() {
        binding.fabScrollDown.setOnClickListener {
            binding.rvImages.layoutManager?.scrollToPosition((imagesAdapter.itemCount - 1) / 2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val IMAGE_KEY = "image"
    }
}