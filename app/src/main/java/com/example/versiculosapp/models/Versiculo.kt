package com.example.versiculosapp.models

class Versiculo(
        var id: String,
        var bookId: String,
        var bibleId: String,
        var content: String,
        var verseCount: Int,
        var reference: String
) {
        override fun toString(): String {
                return "Versiculo(id='$id', bookId='$bookId', bibleId='$bibleId', content='$content', verseCount=$verseCount, reference='$reference')"
        }
}
