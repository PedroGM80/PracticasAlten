package dev.pgm.praactica321

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.pgm.praactica321.ActivityA.Companion.EXTRA_MESSAGE


class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val intent: Intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        if (message?.isNotBlank() == true) Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}