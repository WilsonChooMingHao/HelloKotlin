package Spices

fun makeSpices() {

}

data class SpiceContainer(var spice:Spice) {
    val label = spice.name
}

val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
    SpiceContainer(Curry("Red Curry", "medium")),
    SpiceContainer(Curry("Green Curry", "spicy")))

//for(element in SpiceCabinet) println(element.label)
