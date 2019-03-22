import java.util.*

fun main(args: Array<String>) {
    println("Good ${ if(args[0].toInt() < 12) "morning" else "night"}, Kotlin")

    whatShouldIDoToday("happy")
    /*println(fitMoreFish(10.0, listOf(3,3,3)))
    println(fitMoreFish(8.0, listOf(2,2,2), hasDecorations = false))
    println(fitMoreFish(9.0, listOf(1,1,3), 3))
    println(fitMoreFish(10.0, listOf(), 7, true))*/

    /*var fortune : String = ""
    repeat (10) {
        fortune = getFortuneCookie(getBirthday())
        println("Your Fortune is $fortune")
        if (fortune.contains("Take it easy")) break;
    }*/

    var fortune : String = ""
    while (!fortune.contains("Take it easy")) {
        fortune = getFortuneCookie(getBirthday())
        println("Your fortune is $fortune")
    }

    //feedTheFish()
}

// Lambda that returns a dice roll number between 1 and 12
val rollDice = { Random().nextInt(12) + 1}
val extendRollDice = { sides : Int -> Random().nextInt(sides) + 1}
val rollDice0 = { sides : Int -> if (sides == 0) 0 else Random().nextInt(sides) + 1}
val rollDice2 : (Int) -> Int = { sides -> if (sides == 0) 0 else Random().nextInt(sides) + 1}

// called in main
//gamePlay(rollDice2(4))

fun gamePlay(diceRoll : Int) {
    println(diceRoll)
}

// Kotlin Filters practice
fun funWithSpices() {
    val spices = listOf("curry", "pepper", "cayene", "ginger", "red curry", "green curry", "red pepper")
    //Get spices containing curry and sorted by length
    spices.filter{ it.contains("curry") }.sortedBy { it.length }
    //Get spices starting with c and ending with e
    spices.filter{ it.startsWith('c') }.filter{ it.endsWith('e') }
    //Get first 3 spices and starting with c
    spices.take(3).filter{ it.startsWith('c') }
}

fun whatShouldIDoToday(mood : String,
                       weather : String = "sunny",
                       temperature : Int = 24) : String
{
    fun sadMood (mood : String) = mood == "sad"
    fun rainyWeather(weather : String) = weather == "rainy"
    fun zeroTemp(temperature : Int) = temperature == 0
    fun tempAbove35(temperature : Int) = temperature > 35

    return when {
        mood == "happy" && weather == "sunny" -> "Go for a walk"
        sadMood(mood) && rainyWeather(weather) && zeroTemp(temperature) -> "Stay in bed"
        tempAbove35(temperature) -> "Go Swimming"
        else -> "Stay home and read."
    }
}


fun getFortuneCookie(birthday : Int) : String {
    val fortunes = listOf("You will have a great day!",
        "Things will go well for you today",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")
    return when(birthday) {
        in 1..7 -> "NO FORTUNE"
        28, 31 -> "ENDGAME"
        else -> fortunes[birthday.rem(fortunes.size)]

    }
    //var remainder = birthday.rem(fortunes.size)
    //return fortunes[remainder]
}

fun getBirthday() : Int {
    print("Enter your birthday:")
    var birthday = readLine()?.toIntOrNull() ?: 1
    return birthday
}

fun dayOfWeek(){
    println("What day is it today?")
    when(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
        1 -> println("Sunday")
        2 -> println("Monday")
        3 -> println("Tuesday")
        4 -> println("Wednesday")
        5 -> println("Thursday")
        6 -> println("Friday")
        7 -> println("Saturday")
    }
}

fun shouldChangeWater(day : String,
                      temperature : Int = 22,
                      dirty : Int = 20) : Boolean {
    return true
}

// Lambda stuff
var dirty = 20

val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
fun feedFish(dirty : Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty) { dirty -> dirty + 50 }
}

// Assuming tank has decorations and typical fish 2 inches long
fun fitMoreFish(tankSize : Double,
                currentFish : List<Int>,
                fishSize : Int = 2,
                hasDecorations : Boolean = true) : Boolean {
    var currentSize : Double = tankSize
    // 80% of tankSize usable
    if(hasDecorations)
        currentSize = tankSize.times(0.8);
    // occupy the space with existing fish
    for(i in currentFish) {
        currentSize = currentSize.minus(i)
    }
    // try to occupy space with new fish
    currentSize = currentSize.minus(fishSize)
    if(currentSize < 0.0)
        return false;
    return true;
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eats $food")
    if (shouldChangeWater(day))
        println("Change the water today!")
}

fun randomDay() : String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood (day : String) : String {
    var food = "fasting"

    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}