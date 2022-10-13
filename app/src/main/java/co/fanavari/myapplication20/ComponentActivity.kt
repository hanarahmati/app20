package co.fanavari.myapplication20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.fanavari.myapplication20.databinding.ActivityComponentBinding
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar

class ComponentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComponentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    // Handle edit text press
                    true
                }
                R.id.favorite -> {
                    showToast("favorite clicked")
                    // Handle favorite icon press
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                else -> false
            }
        }

        binding.bottomAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
        }

        binding.bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    // Handle search icon press
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                else -> false
            }
        }

        binding.floatingActionButton.setOnClickListener {
            if(binding.bottomAppBar.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
        }

        val checkedRadioButtonId = binding.radioGroup.checkedRadioButtonId

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            // Responds to child RadioButton checked/unchecked
            when(checkedId){
                R.id.radio_button_1 -> showToast("radio button 1 clicked")

            }
        }

// To check a radio button
        binding.radioButton2.isChecked = true

// To listen for a radio button's checked/unchecked state changes
        binding.radioButton2.setOnCheckedChangeListener { buttonView, isChecked ->
            // Responds to radio button being checked/unchecked
        }

        binding.check1.setOnClickListener {
            val checked: Boolean = binding.check2.isChecked
            if(checked)
                binding.radioButton3.isChecked = true
        }

        binding.check2.setOnClickListener {
            val checked: Boolean = binding.check2.isChecked
            if(checked)
                Snackbar.make(binding.linearComponent,"snackbar",
                    Snackbar.LENGTH_INDEFINITE).setAction("retry"){
                        //response to action
                }.show()
        }

    }
}