package com.elysium.mainpage.sidebar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.elysium.mainpage.databinding.MainPageSideBarLayoutBinding

class SideBarLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    val binding = MainPageSideBarLayoutBinding.inflate(LayoutInflater.from(context), this)
}