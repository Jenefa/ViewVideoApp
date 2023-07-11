package com.example.viewvideoapp.customComponent

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import androidx.constraintlayout.widget.Constraints.LayoutParams
import com.google.android.material.slider.Slider


class CustomSlider @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : Slider(context, attrs, defStyleAttr) {

    init {
        // Update the height of the slider
        val layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT, // Use MATCH_PARENT for the width, or specify a specific value
            100 // Specify the desired height of the slider
        )

        val thumbDrawable = GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setColor(Color.RED)
        }
        Log.d("slider", "outside")
        // Set custom thumb drawable for API level 21
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            Log.d("slider", "below 21")
            try {
                val thumbField = Slider::class.java.getDeclaredField("mThumbDrawable")
                thumbField.isAccessible = true
                thumbField.set(this, thumbDrawable)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        this.layoutParams = layoutParams
    }
}