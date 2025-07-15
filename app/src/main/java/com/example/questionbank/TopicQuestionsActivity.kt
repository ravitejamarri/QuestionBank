package com.example.questionbank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.questionbank.databinding.ActivityTopicQuestionsBinding

class TopicQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTopicQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopicQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val topicName = intent.getStringExtra("topicName")
        binding.topicName.text = topicName

        val topic = MockDB.topics.find { it.name == topicName }
        if (topic != null) {
            binding.questionsRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.questionsRecyclerView.adapter = QuestionAdapter(topic.questions)
        }
    }
}
