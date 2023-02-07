package com.example.customview_prec

import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class SecondActivity : AppCompatActivity() {
    val TAG = "SecondActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        imageSlider();
        setAnimation();

    }

    private fun setAnimation() {

        var runnable : Runnable
        val delay = 3000 //Delay for 15 seconds.  One second = 1000 milliseconds.

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {

                val anim = ValueAnimator.ofFloat(1f, 1.5f)
                anim.duration = 1500
                anim.addUpdateListener { animation ->
                    imageView.scaleX = animation.animatedValue as Float
                    imageView.scaleY = animation.animatedValue as Float
                }
                anim.repeatCount = 1
                anim.repeatMode = ValueAnimator.REVERSE
                anim.start()
                handler.postDelayed(this, delay.toLong())
            }
        }, delay.toLong())




            val anim = ValueAnimator.ofFloat(1f, 1.5f)
            anim.duration = 1500
            anim.addUpdateListener { animation ->
                imageView.scaleX = animation.animatedValue as Float
                imageView.scaleY = animation.animatedValue as Float
            }
            anim.repeatCount = 1
            anim.repeatMode = ValueAnimator.REVERSE
            anim.start()



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