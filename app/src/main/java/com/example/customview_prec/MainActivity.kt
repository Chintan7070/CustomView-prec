package com.example.customview_prec

import android.content.Intent
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.example.customview_prec.modelclass.ModelClass
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        secProgress()
        clickEvents();
    }

    private fun clickEvents() {
        var i = 0
        var list = ArrayList<ModelClass>()
        while (i < 5) {
            val name = "name$i"
            var  modelClass : ModelClass = ModelClass(name,i)
            list.add(modelClass)
            i++
        }

        sendPrcelable.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
//            intent.putExtra("Birds", list)
            startActivity(intent)

        }
    }

    private fun secProgress() {
        seekBar.thumb = getCurrentThumb(seekBar.progress)
        seekBar.progressDrawable = resources.getDrawable(R.drawable.sec_progress_bg)
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                seekBar.thumb = getCurrentThumb(seekBar.progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

    }

    fun getCurrentThumb(currentProgress: Int): Drawable? {

        val drawable = ContextCompat.getDrawable(this, R.drawable.sec_custom_thumb)
        var bitmap = drawable?.toBitmap()
        bitmap = addText(bitmap!!, currentProgress)
        val d = BitmapDrawable(bitmap)

        return d
    }


    fun addText(src: Bitmap, currentProgress: Int): Bitmap? {
        var bitmapConfig = src.config
        if (bitmapConfig == null) bitmapConfig = Bitmap.Config.ARGB_8888
        val bitmap = src.copy(bitmapConfig, true)
        val canvas = Canvas(bitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.setColor(Color.BLUE)
        paint.setStyle(Paint.Style.FILL)
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD))
        paint.setTextAlign(Paint.Align.CENTER)
        paint.setTextSize(70F)
        val rectangle = Rect()
        paint.getTextBounds(
            currentProgress.toString(),
            0,  // start4
            currentProgress.toString().length,
            rectangle
        )
        canvas.drawText(
            currentProgress.toString(),
            canvas.getWidth() / 2.0f,
            canvas.getHeight() / 2.0f + Math.abs(rectangle.height()) / 2.0f,  // y
            paint // Paint
        )
        return bitmap
    }
}