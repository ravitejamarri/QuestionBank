package com.example.questionbank

object MockDB {
    val users = mutableListOf<User>()
    val topics = mutableListOf<Topic>()

    init {
        // Initialize with some sample data
        val techTopic = Topic("Technology")
        val scienceTopic = Topic("Science")
        val mathTopic = Topic("Math")
        val historyTopic = Topic("History")
        val literatureTopic = Topic("Literature")
        val othersTopic = Topic("Others")

        val q1 = Question("What is AI?")
        q1.answers.add(Answer("AI stands for Artificial Intelligence.", 3, 1))
        techTopic.questions.add(q1)

        val q2 = Question("What is the speed of light?")
        q2.answers.add(Answer("The speed of light in a vacuum is 299,792,458 meters per second.", 5, 0))
        scienceTopic.questions.add(q2)

        val q3 = Question("What is the Pythagorean theorem?")
        q3.answers.add(Answer("a^2 + b^2 = c^2", 10, 0))
        mathTopic.questions.add(q3)

        val q4 = Question("Who was the first president of the United States?")
        q4.answers.add(Answer("George Washington", 7, 0))
        historyTopic.questions.add(q4)

        val q5 = Question("Who wrote 'To Kill a Mockingbird'?")
        q5.answers.add(Answer("Harper Lee", 8, 0))
        literatureTopic.questions.add(q5)

        topics.add(techTopic)
        topics.add(scienceTopic)
        topics.add(mathTopic)
        topics.add(historyTopic)
        topics.add(literatureTopic)
        topics.add(othersTopic)
    }
}
