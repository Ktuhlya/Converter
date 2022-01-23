package converter
import java.math.BigInteger
import java.util.*
import kotlin.math.*

const val BIN = 2
const val OCT = 8
const val DEC = 10
const val HEX = 16
val hexTable = arrayListOf<String>("0", "1", "2", "3", "4", "5",
    "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")
val testList = mutableListOf<String>()


fun main() {

    for (i in 0..9) {
         testList. add(i.toString())
    }
    for (i in 'A'..'Z') {
        testList.add(i.toString())
    }


    println(testList)
    workFun()
    print("Do you want to convert /from decimal or /to decimal? " +
            "(To quit type /exit) > ")
    var typeConversion = readLine()!!
    var inputNum = 0
    var targetBase = 0



    var inputNumString = ""

    if (typeConversion == "/exit")  System.exit(0)
    if (typeConversion == "/from") {
        print("Enter number in decimal system: > ")
         inputNum = readln().toInt()
        print("Enter target base: > ")
         targetBase = readln().toInt()
    }
    if (typeConversion =="/to"){
        print("Enter source number: > ")
         inputNumString = readLine()!!.uppercase(Locale.getDefault())
        print("Enter source base: > ")
         targetBase = readln().toInt()
    }

    if ((targetBase == BIN) && (typeConversion == "/from")) decToBin(inputNum)
    if ((targetBase == OCT ) && (typeConversion == "/from")) decToOct(inputNum)
    if ((targetBase == HEX) && (typeConversion == "/from")) decToHex(inputNum)
    if ((targetBase == BIN) && (typeConversion == "/to")) binToDec(inputNumString)
    if ((targetBase == OCT ) && (typeConversion == "/to")) octToDec(inputNumString)
    if ((targetBase == HEX) && (typeConversion == "/to")) hexToDec(inputNumString)
}
///////////////////////////////////////
///////////////////////////////////////

fun workFun() {
    println("sourceBase")
    var sourceBaseEx = readLine()!!.toBigInteger()
    println("targetBase")
    var targetBaseEx = readLine()!!.toBigInteger()
    println("inputNumber")
    var inputNumberEx = readLine()!!
    //  var (quotient, remainder) = inputNumberEx.toBigInteger()
    //      .divideAndRemainder(targetBaseEx)
    var result = BigInteger.valueOf(0)

    // if (sourceBaseEx.toInt() > 10) {
    for (i in inputNumberEx.length - 1 downTo 0) {
        val targetPow = sourceBaseEx.toDouble()
        result += BigInteger.valueOf(
            (testList.indexOf(inputNumberEx[i].toString()) *
                    targetPow.pow(inputNumberEx.length - i - 1)).toLong()
        )
    }
    println(result)
    workFun()
}
 /* }else {

      for (i in inputNumberEx.length - 1 downTo 0) {
          val targetPow = sourceBaseEx.toDouble()
          result += BigInteger.valueOf(
              (inputNumberEx[i].digitToInt() *
                      targetPow.pow(inputNumberEx.length - i - 1)).toLong()
          )
      }
      println(result)
  }


       main()
}
/*
fun hexToDec(hex: String) {
   var dec = 0
    for (i in hex.length-1 downTo  0) {
        val hexPow = 16.0
        dec += (hexTable.indexOf(hex[i].toString())
                * hexPow.pow(hex.length - 1 - i)).toInt()
    }


formula
result = inputNumberEx.Index * targetBase.pow(inputNumbEx.index)
 */
*/


////////////////////////////////////////
////////////////////////////////////////

fun decToHex(dec: Int) {
    var hex : String = converter.hexTable[(dec%16)]
    var remainder  = 0
    var quotient = dec / 16
    do {
        remainder = quotient % 16
        quotient /= 16
        hex = hexTable[remainder] + hex
    } while ( quotient != 0)
    if (hex[0].toString() == "0" ) hex= hex.substring(1)

    println("Conversion result: " + hex)
    main()

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
    if (oct[0].digitToInt() == 0 ) oct= oct.substring(1)
            println("Conversion result: " + oct)
    main()

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
    if (bin[0].digitToInt() == 0 ) bin= bin.substring(1)
  println("Conversion result: " + bin)

    main()

}


fun hexToDec(hex: String) {
   var dec = 0
    for (i in hex.length-1 downTo  0) {
        val hexPow = 16.0
        dec += (hexTable.indexOf(hex[i].toString())
                * hexPow.pow(hex.length - 1 - i)).toInt()
    }

println("Conversion to decimal result: " + dec)
    main()
}

fun octToDec(oct: String) {
    var dec = 0
    for( i  in oct.length-1 downTo 0) {
       val octPow = 8.0
        dec += (oct[i].digitToInt() * octPow.pow(oct.length - i - 1)).toInt()
    }
println("Conversion to decimal result: " + dec)
    main()

}

fun binToDec(bin: String) {
   var dec = 0
    for( i in bin.length-1 downTo 0){
        val binPow = 2.0
        dec += ((bin[i].digitToInt()) * binPow.pow(bin.length - 1 - i)).toInt()
    }
    println("Conversion to decimal result: " + dec)
    main()


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


