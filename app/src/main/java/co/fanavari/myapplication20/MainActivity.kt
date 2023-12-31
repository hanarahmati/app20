package co.fanavari.myapplication20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.fanavari.myapplication20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonForGroup.setOnClickListener {
            binding.group.visibility = View.VISIBLE


        }
    }
}