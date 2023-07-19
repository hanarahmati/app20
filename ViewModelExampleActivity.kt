class ViewModelExampleActivity : AppCompatActivity() {

    private lateinit var viewModel: ScoreViewModel
    private lateinit var scoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel_example)

        scoreTextView = findViewById(R.id.scoreTextView)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)

        // Observe score changes
        viewModel.score.observe(this, Observer { score ->
            scoreTextView.text = score.toString()
        })
    }

    fun incrementScore(view: View) {
        viewModel.incrementScore()
    }
}

class ScoreViewModel : ViewModel() {

    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    init {
        // Initialize score to 0
        _score.value = 0
    }

    fun incrementScore() {
        _score.value = _score.value?.plus(1)
    }

    override fun onCleared() {
        // Release resources
        super.onCleared()
    }
}