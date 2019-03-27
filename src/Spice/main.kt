package Spice

fun main (args:Array<String>) {
    //val simpleSpice = SimpleSpice()
    //println("${simpleSpice.name} ${simpleSpice.heat}")

    val spices = listOf(
        SimpleSpice("Curry", "mild"),
        SimpleSpice("Pepper", "medium"),
        SimpleSpice("Cayenne", "spicy"),
        SimpleSpice("Ginger", "mild"),
        SimpleSpice("Red Curry", "medium"),
        SimpleSpice("Green Curry", "mild"),
        SimpleSpice("Hot Pepper", "extremely spicy")
    )

    val spice = SimpleSpice("Cayenne", spiciness = "spicy")

    val spicelist = spices.filter { it.heat < 5 }

}

fun makeSalt() = SimpleSpice("Salt")