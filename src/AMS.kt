import java.util.*

fun main(args: Array<String>) {
    println("Good ${ if(args[0].toInt() < 12) "morning" else "night"}, Kotlin")

    whatShouldIDoToday("happy")
    /*println(fitMoreFish(10.0, listOf(3,3,3)))
    println(fitMoreFish(8.0, listOf(2,2,2), hasDecorations = false))
    println(fitMoreFish(9.0, listOf(1,1,3), 3))
    println(fitMoreFish(10.0, listOf(), 7, true))*/

    /*var fortune : String
    for (i in 1..10) {
        fortune = getFortuneCookie(getBirthday())
        println("Your fortune is $fortune")
        if (fortune.contains("Take it easy")) break
    }*/

    //feedTheFish()
}

fun whatShouldIDoToday(mood : String,
                       weather : String = "sunny",
                       temperature : Int = 24) : String
{

    return when {
        mood == "happy" && weather == "sunny" -> "Go for a walk"
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