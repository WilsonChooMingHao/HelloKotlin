package Lesson5.Collections

fun main(args:Array<String>) {
    val allBooks = setOf("Macbeth", "The Tempest", "Romeo and Juliet", "Hamlet")
    val library = mapOf("Shakespeare" to allBooks)

    library.any { it.value.contains("Hamlet") }

    val moreBooks = mutableMapOf<String, String>("Wilhelm Tell" to "Schiller")
    moreBooks.getOrPut("Jungle Book") { "Kipling" }
    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    println(moreBooks)
}