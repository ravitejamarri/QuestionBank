package com.example.questionbank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.questionbank.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstName = intent.getStringExtra("firstName")
        binding.greeting.text = "Hello $firstName, welcome to QuestionBank"

        binding.topicsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.topicsRecyclerView.adapter = TopicAdapter(MockDB.topics)
    }
}
