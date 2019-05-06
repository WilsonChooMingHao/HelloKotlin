package Lesson5.Constants

const val MAX_BOOKS_TO_BORROW = 200

class Book(val title : String, val author : String, val year : Int) {
    fun getTitleAuthorPair() : Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYearTriple() : Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBorrow(hasBooks : Int) : Boolean {
        return (hasBooks < MAX_BOOKS_TO_BORROW)
    }

    fun printUrl() {
        println(Constants.BASE_URL + title + ".html")
    }

    companion object {
        val BASE_URL = "http://turtlecare.net"
    }
}

object Constants {
    const val BASE_URL = "http://turtlecare.net"
}