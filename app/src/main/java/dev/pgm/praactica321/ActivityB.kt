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


private const val COLOR_RED = "#FF0000"

private const val COLOR_GREEN = "#1AD321"

private const val COLOR_BLUE = "#3F51B5"

class ActivityB : AppCompatActivity() {

    private val onClickButtonRed = View.OnClickListener {

        val intentColor = Intent(this@ActivityB, ActivityA::class.java)
        intentColor.putExtra(EXTRA_COLOR_VALUE, COLOR_RED)
        setResultAndFinish(intentColor)
    }

    private val onClickButtonGreen = View.OnClickListener {

        val intentColor = Intent(this@ActivityB, ActivityA::class.java)
        intentColor.putExtra(EXTRA_COLOR_VALUE, COLOR_GREEN)
        setResultAndFinish(intentColor)
    }
    private val onClickButtonBlue = View.OnClickListener {

        val intentColor = Intent(this@ActivityB, ActivityA::class.java)
        intentColor.putExtra(EXTRA_COLOR_VALUE, COLOR_BLUE)
        setResultAndFinish(intentColor)
    }

    private fun setResultAndFinish(intentColor: Intent) {

        setResult(RESULT_OK, intentColor)
        finish()
    }

    private val getButtonRed: Button
        get() = findViewById(R.id.activityB__btn__back__color_red)

    private val getButtonGreen: Button
        get() = findViewById(R.id.activityB__btn__back__color_green)

    private val getButtonBlue: Button
        get() = findViewById(R.id.activityB__btn__back__color_blue)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        if (message != null) {

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        getButtonRed.setOnClickListener(onClickButtonRed)
        getButtonGreen.setOnClickListener(onClickButtonGreen)
        getButtonBlue.setOnClickListener(onClickButtonBlue)
    }
}