package co.fanavari.myapplication20

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import co.fanavari.myapplication20.databinding.ActivityDashboardBinding
import com.google.android.material.button.MaterialButton

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_dashboard)
        setContentView(binding.root)

        print("on create")

        val buttonTodo: MaterialButton = findViewById(R.id.todoButton)
        buttonTodo.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        val openIntentForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                if(it.resultCode == Activity.RESULT_OK)
                    showToast(it.data?.getStringExtra("message").toString())
                else
                    showToast("empty data")
            }

        binding.editProfileButton.setOnClickListener {
            Toast.makeText(this,"edited profile",Toast.LENGTH_LONG).show()

            openIntentForResult.launch(
                Intent(this, IntentExamplesActivity::class.java).apply {
                   putExtra("id", 1)
                }
            )
        }

        binding.profileButton.setOnClickListener{
            showToast("my profile")
            val intent = Intent(this, IntentExamplesActivity::class.java)
            val mentorName = binding.textViewMentorName.text.toString()
            intent.putExtra(Constants.MENTOR_NAME,mentorName)
            intent.putExtra("classNumber",20)
            startActivity(intent)
        }



    }

    override fun onStart() {
        super.onStart()
        print("on start")
    }

    override fun onResume() {
        super.onResume()
        print("on resume")
    }

    override fun onStop() {
        super.onStop()
        print("on stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        print("on destroy")
    }

    /*override fun onBackPressed() {
        super.onBackPressed()
        print("on back pressed!")
    }*/

    private fun print(msg: String){
        Log.i("activity state", "activity state : $msg")
    }

}