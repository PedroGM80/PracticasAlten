package dev.pgm.praactica321

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class ActivityA : AppCompatActivity() {

    private val request = 1

    companion object {
        const val EXTRA_MESSAGE = "Message"
        const val EXTRA_COLOR_VALUE = "Color"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        if (intent.hasExtra(EXTRA_COLOR_VALUE)) {
            val colorValue = intent.getStringExtra(EXTRA_COLOR_VALUE).toString()
            val constraintLayout = findViewById<ConstraintLayout>(R.id.activityAConstraintInitialView)
            constraintLayout.setBackgroundColor(Color.parseColor(colorValue))
        }
        val buttonLaunchToast: Button = findViewById(R.id.activityBtnLaunchIntent)
        val buttonLaunchResult: Button = findViewById(R.id.activityBtnLaunchIntentResult)
        val buttonWebOpen: Button = findViewById(R.id.activityBtnLaunchIntentWeb)

        buttonLaunchToast.setOnClickListener {

            val intent = Intent(this, ActivityB::class.java)
            val editTextMsn: EditText = findViewById(R.id.activityAEditTextMessageUserIn)
            val message: String = editTextMsn.text.toString()

            intent.putExtra(EXTRA_MESSAGE, message)
            startActivity(intent)

        }

        buttonLaunchResult.setOnClickListener {

            val intent = Intent(this, ActivityB::class.java)
            val editTextMsn: EditText = findViewById(R.id.activityAEditTextMessageUserIn)
            val message: String = editTextMsn.text.toString()

            intent.putExtra(EXTRA_MESSAGE, message)
            startActivityForResult(intent, request)
        }

        buttonWebOpen.setOnClickListener {

            val url = "http://www.google.com"
            val webOpenIntent = Intent(Intent.ACTION_VIEW)

            webOpenIntent.data = Uri.parse(url)
            startActivity(webOpenIntent)
        }
    }
}