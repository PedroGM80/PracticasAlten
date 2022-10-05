package dev.pgm.praactica321

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class ActivityA : AppCompatActivity() {
    // private val LOG_TAG: String = ActivityA::class.java.simpleName
    val TEXT_REQUEST = 1

    // Unique tag required for the intent extra
    companion object {
        const val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        val buttonLaunchToast: Button = findViewById(R.id.activityBtnLaunchIntent)
        val buttonLaunchResult: Button = findViewById(R.id.activityBtnLaunchIntentResult)
        val buttonWebOpen:Button=findViewById(R.id.activityBtnLaunchIntentWeb)
        buttonLaunchToast.setOnClickListener {

            val intent = Intent(this, ActivityB::class.java)
            val editTextMsn: EditText = findViewById(R.id.activityEditTextTextTop)
            val message: String = editTextMsn.text.toString()

            intent.putExtra(EXTRA_MESSAGE, message)
            startActivity(intent)
            //  startActivityForResult(intent, TEXT_REQUEST)
        }

        buttonLaunchResult.setOnClickListener {

            val intent = Intent(this, ActivityB::class.java)
            val editTextMsn: EditText = findViewById(R.id.activityEditTextTextTop)
            val message: String = editTextMsn.text.toString()

            intent.putExtra(EXTRA_MESSAGE, message)

            startActivityForResult(intent, TEXT_REQUEST)
        }

        buttonWebOpen.setOnClickListener{
            val url = "http://www.google.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }
}