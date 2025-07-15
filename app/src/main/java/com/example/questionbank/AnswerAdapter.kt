package com.example.questionbank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnswerAdapter(private val answers: MutableList<Answer>) :
    RecyclerView.Adapter<AnswerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val answerText: TextView = view.findViewById(R.id.answerText)
        val likeButton: ImageButton = view.findViewById(R.id.likeButton)
        val dislikeButton: ImageButton = view.findViewById(R.id.dislikeButton)
        val likeCount: TextView = view.findViewById(R.id.likeCount)
        val dislikeCount: TextView = view.findViewById(R.id.dislikeCount)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_answer, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val answer = answers[position]
        viewHolder.answerText.text = answer.text
        viewHolder.likeCount.text = answer.likes.toString()
        viewHolder.dislikeCount.text = answer.dislikes.toString()

        viewHolder.likeButton.setOnClickListener {
            answer.likes++
            notifyItemChanged(position)
        }

        viewHolder.dislikeButton.setOnClickListener {
            answer.dislikes++
            notifyItemChanged(position)
        }
    }

    override fun getItemCount() = answers.size
}
