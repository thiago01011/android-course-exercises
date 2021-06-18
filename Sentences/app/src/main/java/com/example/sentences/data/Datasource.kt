package com.example.sentences.data

import com.example.sentences.R
import com.example.sentences.model.Sentence

class Datasource {
    fun loadSentences(): List<Sentence> {
        return listOf<Sentence>(Sentence(R.string.affirmation1, R.drawable.image1),
            Sentence(R.string.affirmation2, R.drawable.image2),
            Sentence(R.string.affirmation3, R.drawable.image3),
            Sentence(R.string.affirmation4, R.drawable.image4),
            Sentence(R.string.affirmation5, R.drawable.image5),
            Sentence(R.string.affirmation6, R.drawable.image6),
            Sentence(R.string.affirmation7, R.drawable.image7),
            Sentence(R.string.affirmation8, R.drawable.image8),
            Sentence(R.string.affirmation9, R.drawable.image9),
            Sentence(R.string.affirmation10, R.drawable.image10)
        )
    }
}