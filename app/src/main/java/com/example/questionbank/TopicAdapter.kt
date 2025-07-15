package com.example.questionbank

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopicAdapter(private val topics: List<Topic>) :
    RecyclerView.Adapter<TopicAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(android.R.layout.simple_list_item_1, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val topic = topics[position]
        viewHolder.textView.text = topic.name
        viewHolder.itemView.setOnClickListener {
            val intent = Intent(it.context, TopicQuestionsActivity::class.java)
            intent.putExtra("topicName", topic.name)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = topics.size
}
