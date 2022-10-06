package dev.pgm.praactica321

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.pgm.praactica321.ActivityA.Companion.EXTRA_COLOR_VALUE
import dev.pgm.praactica321.ActivityA.Companion.EXTRA_MESSAGE


class ActivityB : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)


        val message = intent.getStringExtra(EXTRA_MESSAGE)
        if (message?.isNotBlank() == true) {

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        val buttonRed: Button = findViewById(R.id.activityBtnBackColorRed)
        val buttonGreen: Button = findViewById(R.id.activityBtnBackColorGreen)
        val buttonBlue: Button = findViewById(R.id.activityBtnBackColorBlue)

        buttonRed.setOnClickListener {

            val intentColor = Intent(this, ActivityA::class.java)
            intentColor.putExtra(EXTRA_COLOR_VALUE, R.color.red)
            startActivity(intentColor)
        }

        buttonGreen.setOnClickListener {

            val intentColor = Intent(this, ActivityA::class.java)
            intentColor.putExtra(EXTRA_COLOR_VALUE, R.color.green.toString())
            startActivity(intentColor)
        }
        buttonBlue.setOnClickListener {

            val intentColor = Intent(this, ActivityA::class.java)
            intentColor.putExtra(EXTRA_COLOR_VALUE, R.color.blue.toString())
            startActivity(intentColor)
        }
    }
}