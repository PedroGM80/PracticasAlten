package dev.pgm.praactica321

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


const val EXTRA_MESSAGE = "twoactivities.extra.MESSAGE"

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        val button: Button = findViewById(R.id.activityBtnLaunchIntent)

        button.setOnClickListener {

            val intent = Intent(this, ActivityB::class.java)
            val editTextMsn: EditText = findViewById(R.id.activityEditTextTextTop)
            val message: String = editTextMsn.text.toString()

            intent.putExtra(EXTRA_MESSAGE, message)
            startActivity(intent)
        }
    }
}