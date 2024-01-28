package com.elysium.mainpage

import android.graphics.Color
import android.os.Bundle
import com.elysium.basic.activity.ElysiumActivity
import com.elysium.mainpage.databinding.MainPageActivityBinding

class MainPageActivity : ElysiumActivity() {

    val binding by lazy { MainPageActivityBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.drawerLayout.setScrimColor(Color.TRANSPARENT)
    }
}