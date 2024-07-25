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
     * Long: 64 bits (8 byte)
     */

    // The integer literal does not conform to the expected type Byte
    //val myByte:Byte = 128

    val myByte: Byte = 127 // Byte is in range

    val myInt: Int = 128
    val myShort: Short = 128
    val myLong: Long = 128

    println("$myInt")
}