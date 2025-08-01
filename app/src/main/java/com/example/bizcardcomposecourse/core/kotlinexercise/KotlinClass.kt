package com.example.bizcardcomposecourse.core.kotlinexercise

fun main() {
    typesInKotlin()
    lambdaExpression()
    genericsInKotlin()
}

fun typesInKotlin() {
    /**
     * Types in Kotlin
     *
     * Byte: 8 bits (1 byte)
     * Short: 16 bits (2 byte)
     * Int: 32 bits (4 byte)
     * Float: 32 bits (4 byte)  //decimal numbers
     * Double: 64 bits (8 byte) //decimal numbers
     * Long: 64 bits (8 byte)
     */

    // The integer literal does not conform to the expected type Byte
    //val myByte:Byte = 128

    val myByte: Byte = 127 // Byte is in range
    val myInt: Int = 128 //Byte is out of range for this one so we must use an Int
    val myShort: Short = 128
    val myLong: Long = 128

    println("$myInt")

    /**
     * 3.14234332334 // Double
     * 3.1423433 // Float
     *
     * Floating-point literal cannot be represented with the required precision
     */
    val numberOnRange: Double = 3.14234332334
    println(numberOnRange)

    @Suppress("FloatingPointLiteralPrecision")
    val numberOutOfRange: Float = 3.14234332334F
    println(numberOutOfRange)

    /**
     * This method demonstrates the integer wraparound behavior in Kotlin.
     * When an integer value exceeds the maximum value representable by an Int,
     * the value "wraps around" to the opposite end of the range.
     *
     * For example, the maximum value representable by an Int is Int.MAX_VALUE (2147483647).
     * If you try to add 1 to this value,you will get Int.MIN_VALUE (-2147483648).
     */
    val maxValue = Int.MAX_VALUE
    @Suppress("INTEGER_OVERFLOW")
    println(maxValue + 1) // Output: -2147483648
}

fun lambdaExpression() {
    println(sum(2, 2))
    println(sumLambda(2, 2))
    name("Name")

    enhanceMessage("Hello") { sum(2, 2) }
    enhanceMessage("Hello") { sumLambda(4, 2) }
    /**
     * As you can see, this method executes the body function without checking whether a function is used within the body.
     * The return type of the function is the only factor considered; in this case, 12 is an Int, so it's acceptable.
     */
    enhanceMessage("Hello") { 12 }

    enhanceMessageWithInputParameterInLambda("Hello") { stringParam ->
        println("enhanceMessageWithInputParameterInLambda")
        println(stringParam)
        12 // or sumLambda(4, 2)
    }
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * A lambda expression is a shorter way to define a function.
 */
// val lambdaName: (InputType) -> ReturnType = { arguments: InputType -> body }
val sumLambda: (Int, Int) -> Int = { a, b -> a + b }
val name: (String) -> Unit = { println(it) }

/**
 * Trailing lambda
 * You can pass functions parameters to a function
 *
 * According to Kotlin convention, if the last parameter of a function is a function, you can place the lambda outside the parenthesis
 * (e.g.: enhanceMessage("Hello") { sum(2, 2) })
 */
fun enhanceMessage(message: String, functionAsParameter: () -> Int) {
    println("$message ${functionAsParameter()}")
}

fun enhanceMessageWithInputParameterInLambda(
    message: String,
    functionAsParameter: (String) -> Int
) {
    println("$message ${functionAsParameter("String Param")}") //this println will be executed only when functionAsParameter returns a value
}


fun genericsInKotlin() {
    val listOfNumbers = listOf(1, 2, 3, 4, 5)
    val listOfStrings = listOf("One", "Two", "Three", "Four", "Five")

    val finder = Finder(listOfNumbers)
    finder.findItem(2) {
        println("genericsInKotlin() $it")
    }
}

class Finder<T>(private val list: List<T>) {

    fun findItem(element: T, foundItem: (element: T?) -> Unit) {
        val itemFoundList = list.filter { it == element }
        foundItem(itemFoundList.firstOrNull())
    }
}