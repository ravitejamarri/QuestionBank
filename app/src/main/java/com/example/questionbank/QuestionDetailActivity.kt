package com.example.questionbank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.questionbank.databinding.ActivityQuestionDetailBinding

class QuestionDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionDetailBinding
    private lateinit var question: Question
    private lateinit var answerAdapter: AnswerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val questionText = intent.getStringExtra("questionText")
        binding.questionText.text = questionText

        // Find the question from the mock database
        question = MockDB.topics.flatMap { it.questions }.find { it.text == questionText }!!

        binding.answersRecyclerView.layoutManager = LinearLayoutManager(this)
        answerAdapter = AnswerAdapter(question.answers)
        binding.answersRecyclerView.adapter = answerAdapter

        binding.submitReply.setOnClickListener {
            val replyText = binding.reply.text.toString()
            if (replyText.isNotEmpty()) {
                val newAnswer = Answer(replyText)
                question.answers.add(newAnswer)
                answerAdapter.notifyItemInserted(question.answers.size - 1)
                binding.reply.text.clear()
            }
        }
    }
}
