package dev.pgm.praactica321

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import dev.pgm.practica322.R


class ActivityA : AppCompatActivity() {

    private val onClickButtonResultV1 = View.OnClickListener {
        val intent = getIntentMessage()
        startActivityForResult(intent, REQUEST_CODE)
    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data
                setBackgroundColorOfIntent(data)
            }
        }

    private fun setBackgroundColorOfIntent(data: Intent?) {
        val colorValue = data?.getStringExtra(EXTRA_COLOR_VALUE).toString()
        val constraintLayout = findViewById<ConstraintLayout>(R.id.activityAConstraintInitialView)
        constraintLayout.setBackgroundColor(Color.parseColor(colorValue))
    }

    private val onClickButtonResultV2 = View.OnClickListener {
        val intent = getIntentMessage()
        resultLauncher.launch(intent)
    }

    private fun getIntentMessage(): Intent {
        val intent = Intent(this@ActivityA, ActivityB::class.java)
        val editTextMsn: EditText = findViewById(R.id.activityA__editText__Message_UserIn)
        val message: String = editTextMsn.text.toString()

        intent.putExtra(EXTRA_MESSAGE, message)
        return intent
    }

    private val onClickButtonOpenWeb = View.OnClickListener {

        val url = "https://codelabs.developers.google.com/android-training/"
        val webOpenIntent = Intent(Intent.ACTION_VIEW)

        webOpenIntent.data = Uri.parse(url)
        startActivity(webOpenIntent)
    }

    companion object {
        const val EXTRA_MESSAGE = "Message"
        const val EXTRA_COLOR_VALUE = "Color"
        const val REQUEST_CODE = 2
    }

    private val getButtons: Triple<Button, Button, Button>
        get() {
            val buttonLaunchToast: Button = findViewById(R.id.activityA__btn__launch_toast)
            val buttonLaunchResult: Button = findViewById(R.id.activityB__btn__launch_toast2)
            val buttonWebOpen: Button = findViewById(R.id.activityA__btn__launch_web)
            return Triple(buttonLaunchToast, buttonLaunchResult, buttonWebOpen)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        getButtons.first.setOnClickListener(onClickButtonResultV1)
        getButtons.second.setOnClickListener(onClickButtonResultV2)
        getButtons.third.setOnClickListener(onClickButtonOpenWeb)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
             setBackgroundColorOfIntent(data)
            }
        }
    }
}