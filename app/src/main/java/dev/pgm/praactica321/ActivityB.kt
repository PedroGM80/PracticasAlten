package dev.pgm.praactica321

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.pgm.praactica321.ActivityA.Companion.EXTRA_COLOR_VALUE
import dev.pgm.praactica321.ActivityA.Companion.EXTRA_MESSAGE
import dev.pgm.practica322.R


class ActivityB : AppCompatActivity() {

    private val onClickButtonRed = View.OnClickListener {

        val intentColor = Intent(this@ActivityB, ActivityA::class.java)
        intentColor.putExtra(EXTRA_COLOR_VALUE, "#FF0000")
        setIntentColor(intentColor)
    }

    private val onClickButtonGreen = View.OnClickListener {

        val intentColor = Intent(this@ActivityB, ActivityA::class.java)
        intentColor.putExtra(EXTRA_COLOR_VALUE, "#1AD321")
        setIntentColor(intentColor)
    }
    private val onClickButtonBlue = View.OnClickListener {

        val intentColor = Intent(this@ActivityB, ActivityA::class.java)
        intentColor.putExtra(EXTRA_COLOR_VALUE, "#3F51B5")
        setIntentColor(intentColor)
    }

    private fun setIntentColor(intentColor: Intent) {

        setResult(RESULT_OK, intentColor)
        finish()
    }

    private val getButtons: Triple<Button?, Button?, Button?>
        get() {

            val buttonRed: Button? = findViewById(R.id.activityB__btn__back__color_red)
            val buttonGreen: Button? = findViewById(R.id.activityB__btn__back__color_green)
            val buttonBlue: Button? = findViewById(R.id.activityB__btn__back__color_blue)
            return Triple(buttonRed, buttonGreen, buttonBlue)
        }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        if (message?.isNotBlank() == true) {

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        getButtons.first?.setOnClickListener(onClickButtonRed)
        getButtons.second?.setOnClickListener(onClickButtonGreen)
        getButtons.third?.setOnClickListener(onClickButtonBlue)
    }
}