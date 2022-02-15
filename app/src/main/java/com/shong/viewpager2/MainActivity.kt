package com.shong.viewpager2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val TAG = this::class.java.simpleName+"_sHong"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        val exampleAdapter = ExampleAdapter()
        viewPager2.run{
            adapter = exampleAdapter

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.d(TAG,"selected page : $position")
                }
            })

            val pageMargin = resources.getDimensionPixelOffset(R.dimen.page_margin).toFloat()
            val pageOffset = resources.getDimensionPixelOffset(R.dimen.pager_offset).toFloat()

            setPageTransformer { page, position ->
                val myOffset: Float = position * -(2 * pageOffset + pageMargin)
                if (position < -1) {
                    page.translationX = -myOffset
                } else if (position <= 1) {
                    val scaleFactor = Math.max(0.7f, 1 - Math.abs(position - 0.14285715f))
                    page.translationX = myOffset
                    page.scaleY = scaleFactor
                }
            }
        }
        val rv = viewPager2.getChildAt(0)
        rv.setPadding(80, 0, 80, 0)
    }

}