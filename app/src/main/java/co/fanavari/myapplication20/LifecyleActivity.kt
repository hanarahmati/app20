class MainActivity : AppCompatActivity() {

    private var score = 0
    private lateinit var scoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreTextView = findViewById(R.id.scoreTextView)

        // Restore saved state if available
        savedInstanceState?.let {
            score = it.getInt("score", 0)
            scoreTextView.text = score.toString()
        }

        // Observe lifecycle events
        lifecycle.addObserver(MyLifecycleObserver())
    }

    inner class MyLifecycleObserver : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun onPause() {
            // Save score to bundle
            val bundle = Bundle().apply {
                putInt("score", score)
            }
            savedInstanceState = bundle
        }
    }

    fun incrementScore(view: View) {
        score++
        scoreTextView.text = score.toString()
    }
}