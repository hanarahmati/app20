package co.fanavari.myapplication20

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import androidx.activity.result.contract.ActivityResultContracts
import co.fanavari.myapplication20.databinding.ActivityIntentExamplesBinding

class IntentExamplesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntentExamplesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentExamplesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val mentorName = "${bundle.getString(Constants.MENTOR_NAME)} class number " +
                    "${bundle.getInt("classNumber")}"
            binding.textViewMentor.text = mentorName

        }

        binding.textViewMentor.setOnClickListener {
            val intent = Intent().apply {
                putExtra("message",binding.textViewMentor.text.toString())
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        binding.buttonOpenUrl.setOnClickListener {
            openUrl()
        }

        binding.buttonComposeEmail.setOnClickListener {
            composeEmail(arrayOf("hana.rahmati@gmail.com","fanavari.co@gmail.com"),"contact us")
        }

        binding.buttonCreateAlarm.setOnClickListener {
            createAlarm("test",11,23)
        }

    }

    private fun openUrl(){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://fanavari.co/android-course/"))
        startActivity(intent)
    }

    fun composeEmail(addresses: Array<String>, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
       // if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
     //   }
    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
       // if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
      //  }
    }
}