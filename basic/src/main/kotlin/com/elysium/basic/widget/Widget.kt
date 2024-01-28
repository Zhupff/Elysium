package com.elysium.basic.widget

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.Keep
import androidx.constraintlayout.widget.ConstraintLayout
import zhupf.gadget.widget.LayoutParamsDsl
import zhupf.gadget.widget.WidgetDsl
import zhupf.gadget.widget.WidgetX

object Widget {

    @Keep
    private class ForCompile {

        @WidgetX("FrameLayoutX", cornerClip = true, windowFit = true)
        lateinit var FrameLayoutX: FrameLayout
        @WidgetX("ConstraintLayoutX", cornerClip = true, windowFit = true)
        lateinit var ConstraintLayoutX: ConstraintLayout


        @WidgetDsl("FrameLayout")
        lateinit var FrameLayout_DSL: FrameLayout
        @WidgetDsl("FrameLayoutX", "com.elysium.basic.widget.FrameLayoutX")
        lateinit var FrameLayoutX_DSL: FrameLayoutX
        @WidgetDsl("ConstraintLayout")
        lateinit var ConstraintLayout_DSL: ConstraintLayout
        @WidgetDsl("ConstraintLayoutX", "com.elysium.basic.widget.ConstraintLayoutX")
        lateinit var ConstraintLayoutX_DSL: ConstraintLayoutX


        @LayoutParamsDsl("ViewLayoutParams")
        lateinit var ViewLayoutParams_DSL: ViewGroup.LayoutParams
        @LayoutParamsDsl("MarginLayoutParams")
        lateinit var MarginLayoutParams_DSL: ViewGroup.MarginLayoutParams
        @LayoutParamsDsl("FrameLayoutParams")
        lateinit var FrameLayoutParams_DSL: FrameLayout.LayoutParams
        @LayoutParamsDsl("ConstraintLayoutParams")
        lateinit var ConstraintLayoutParams_DSL: ConstraintLayout.LayoutParams
    }
}