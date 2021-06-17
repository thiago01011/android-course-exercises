package com.example.sentences.data

import com.example.sentences.R
import com.example.sentences.model.Sentence

class Datasource {
    fun loadSentences(): List<Sentence> {
        return listOf<Sentence>(Sentence(R.string.affirmation1),
            Sentence(R.string.affirmation2),
            Sentence(R.string.affirmation3),
            Sentence(R.string.affirmation4),
            Sentence(R.string.affirmation5),
            Sentence(R.string.affirmation6),
            Sentence(R.string.affirmation7),
            Sentence(R.string.affirmation8),
            Sentence(R.string.affirmation9),
            Sentence(R.string.affirmation10)
        )
    }
}