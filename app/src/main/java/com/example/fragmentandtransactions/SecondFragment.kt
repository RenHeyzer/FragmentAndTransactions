package com.example.fragmentandtransactions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.fragmentandtransactions.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        close()
    }

    private fun getData() = with(binding) {
        arguments?.let {
            val image = it.getSerializable(FirstFragment.IMAGE_KEY) as? Image
            if (image != null) {
                Glide.with(ivImage.context)
                    .load(image.imageUrl)
                    .placeholder(R.drawable.placeholder)
                    .into(ivImage)
                tvTags.text = image.tags.toString().replace("[", "").replace("]", "")
            }
        }
    }

    private fun close() {
        binding.tvTags.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}