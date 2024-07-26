package com.example.bizcardcomposecourse

fun main() {
    typesInKotlin()
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