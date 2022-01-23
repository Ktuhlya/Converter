package converter

const val BIN = 2
const val  OCT = 8
const val DEC = 10
const val HEX = 16
val hexTable = arrayListOf<String>("0", "1", "2", "3", "4", "5",
    "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")

fun main() {
   print("Enter number in decimal system: > ")
    val numDec  = readln().toInt()
    print("Enter target base: > ")
    val targetBase = readln().toInt()
   if (targetBase == BIN) decToBin(numDec)
    if (targetBase == OCT ) decToOct(numDec)
    if (targetBase == HEX) hexToDec(numDec)
}

fun hexToDec(dec: Int) {
    var hex : String = converter.hexTable[(dec%16)]
    var remainder  = 0
    var quotient = dec / 16
    do {
        remainder = quotient % 16
        quotient /= 16
        hex = hexTable[remainder] + hex
    } while ( quotient != 0)
    println("Conversion result: $hex")

}

fun decToOct(dec: Int) {
    var oct: String = (dec%8).toString()
    var remainder = 0
    var quotient = dec / 8
    do {
        remainder = quotient % 8
        quotient /= 8
        oct = remainder.toString() + oct
    }
        while (quotient != 0)
            println("Conversion result: $oct")

}

fun decToBin (dec: Int)  {
   var bin: String   = (dec%2).toString()
    var remainder = 0
    var   quotient = dec/2

    do {
      remainder = quotient % 2
        quotient /= 2
      bin =  remainder.toString() + bin

  } while (quotient != 0)
  println("Conversion result: $bin")

}





/*
if (targetBase == 2) {
    println("Conversion result: " +
            "${Integer.toBinaryString(numDec)}")
}
if (targetBase == 8) {
    println("Conversion result: " +
            "${Integer.toOctalString(numDec)}")
}
if (targetBase == 16) {
    println("Conversion result: " +
            "${Integer.toHexString(numDec)}")
}

 */


