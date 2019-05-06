package Lesson5.Pairs

class Book(val title : String, val author : String, val year : Int) {
    fun getTitleAuthorPair() : Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYearTriple() : Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}

fun main(args: Array<String>) {
    val book = Book("Book Title", "Book Author", 2019)
    val pair = book.getTitleAuthorPair()
    val triple = book.getTitleAuthorYearTriple()

    println("Here is your book ${pair.first} written by ${pair.second}")
    println("Here is your book ${triple.first} written by ${triple.second} in ${triple.third}")
}