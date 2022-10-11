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



class ActivityA : AppCompatActivity() {

    companion object {
        const val EXTRA_MESSAGE = "Message"
        const val EXTRA_COLOR_VALUE = "Color"
        const val REQUEST_CODE = 2
        const val URL = "https://codelabs.developers.google.com/android-training/"
    }

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

        val colorValue: String = data?.getStringExtra(EXTRA_COLOR_VALUE).toString()
        val constraintLayout: ConstraintLayout? =
            findViewById<ConstraintLayout>(R.id.activityAConstraintInitialView)

        if (!colorValue.isNullOrBlank() && constraintLayout != null) {
            constraintLayout.setBackgroundColor(Color.parseColor(colorValue))
        }
    }

    private val onClickButtonResultV2 = View.OnClickListener {

        val intent = getIntentMessage()
        resultLauncher.launch(intent)
    }

    private fun getIntentMessage(): Intent {

        val intent = Intent(this@ActivityA, ActivityB::class.java)
        val editTextMsn: EditText? = findViewById(R.id.activityA__editText__Message_UserIn)

        if (editTextMsn != null) {
            val message: String = editTextMsn.text.toString()
            intent.putExtra(EXTRA_MESSAGE, message)
        }
        return intent
    }

    private val onClickButtonOpenWeb = View.OnClickListener {

        val webOpenIntent = Intent(Intent.ACTION_VIEW)

        webOpenIntent.data = Uri.parse(URL)
        startActivityForResult(webOpenIntent, REQUEST_CODE)

    }

    private val getButtonToast: Button
        get() = findViewById(R.id.activityA__btn__launch_toast)

    private val getButtonLaunchResult: Button
        get() = findViewById(R.id.activityB__btn__launch_toast2)

    private val getButtonWebOpen: Button
        get() = findViewById(R.id.activityA__btn__launch_web)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        getButtonToast.setOnClickListener(onClickButtonResultV1)
        getButtonLaunchResult.setOnClickListener(onClickButtonResultV2)
        getButtonWebOpen.setOnClickListener(onClickButtonOpenWeb)
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