package com.example.fragmentandtransactions

import java.io.Serializable

data class Image(
    val imageUrl: String,
    val tags: List<String>
): Serializable