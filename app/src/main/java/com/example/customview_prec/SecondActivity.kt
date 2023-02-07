package com.example.customview_prec

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.customview_prec.modelclass.ModelClass
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class SecondActivity : AppCompatActivity() {
    val TAG = "SecondActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        imageSlider();

    }

    private fun imageSlider() {

        val carousel: ImageCarousel = findViewById(R.id.carousel)
//        carousel.autoPlay=true
//        carousel.autoPlayDelay = 3000
        carousel.registerLifecycle(lifecycle)
        val list = mutableListOf<CarouselItem>()

        list.add(
            CarouselItem(
                    imageUrl = "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080",
                    caption = "Photo by Aaron Wu on Unsplash"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"
            )
        )

        val headers = mutableMapOf<String, String>()
        headers["header_key"] = "header_value"

        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080",
                headers = headers
            )
        )
        list.add(
            CarouselItem(
                imageDrawable = R.drawable.sec_progress_bg,
                caption = "Photo by Kimiya Oveisi on Unsplash")
        )

        list.add(CarouselItem(
                imageDrawable = R.drawable.ic_launcher_background
            )
        )

        carousel.setData(list)


    }


}