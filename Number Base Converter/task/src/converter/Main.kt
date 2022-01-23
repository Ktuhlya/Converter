package converter

const val BIN = 2
const val  OCT = 8
const val DEC = 10
const val HEX = 16
val hexTable = arrayListOf<String>("0", "1", "2", "3", "4", "5",
    "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")

fun main() {
    print("Do you want to convert /from decimal or /to decimal? " +
            "(To quit type /exit) > ")
    var typeConversion = readLine()!!
    if (typeConversion == "/exit")  System.exit(0)
    print("Enter number in decimal system: > ")
    val inputNum  = readln().toInt()
    print("Enter target base: > ")
    val targetBase = readln().toInt()
    if ((targetBase == BIN) && (typeConversion == "/from")) decToBin(inputNum)
    if ((targetBase == OCT ) && (typeConversion == "/from")) decToOct(inputNum)
    if ((targetBase == HEX) && (typeConversion == "/from")) hexToDec(inputNum)
    if ((targetBase == BIN) && (typeConversion == "/to")) decToBin(inputNum)
    if ((targetBase == OCT ) && (typeConversion == "/to")) decToOct(inputNum)
    if ((targetBase == HEX) && (typeConversion == "/to")) hexToDec(inputNum)
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
    println(hex)

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
            println(oct)

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
  println(bin)

}


fun hecToDec(hex: Int) {

}

fun octToDec(oct: Int) {


}

fun binToDec(bin: Int) {


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


