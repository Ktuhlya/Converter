import java.math.RoundingMode
import java.math.BigDecimal
import java.math.BigInteger

fun main() {
    val char: CharArray = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    home(char)
}

fun home(char: CharArray) {
    print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
    val input = readLine()!!
    if (input == "/exit") return else if (input == "") home(char) else {
        val bases = input.split(" ").map { it.toInt() }
        convert(bases, char)
    }
}

fun convert(bases: List<Int>, char: CharArray) {
    print("Enter number in base ${bases[0]} to convert to base ${bases[1]} (To go back type /back) ")
    val input = readLine()!!
    if (input == "/back") home(char) else if (input == "") convert(bases, char) else {
        var x: BigInteger?
        var str = ""
        if (input.contains('.', true)) {
            x = input.substringBefore(".").toBigIntegerOrNull(bases[0])
            var zero = BigDecimal("0.00000")
            var br = true
            var y = input.substringAfter(".")
            var list = y.split("").filter { it != "" }
            var m: BigDecimal
            var n = BigDecimal.ONE.setScale(5, RoundingMode.UNNECESSARY)
            if (list.size > 0) {
                for (i in 0 until list.size) {
                    n /= bases[0].toBigDecimal().setScale(5, RoundingMode.UNNECESSARY)
                    if (list[i] !in char.map { it.toString() }) m = list[i].toBigDecimal().setScale(5, RoundingMode.UNNECESSARY)
                    else m = char.indexOfFirst { it.toString() == list[i] }.toBigDecimal().setScale(5, RoundingMode.UNNECESSARY) + BigDecimal("10").setScale(5, RoundingMode.UNNECESSARY)
                    zero += m * n
                }
            }
            zero.setScale(5, RoundingMode.HALF_UP)
            if (y.length < 1) br = false
            val bd = bases[1].toBigDecimal().setScale(5, RoundingMode.UNNECESSARY)
            var nm: Int
            var one = BigDecimal.ONE.setScale(5, RoundingMode.UNNECESSARY)
            var add = ""
            if (br) {
                str = "."
                for (i in 1..5) {
                    nm = 0
                    add = ""
                    zero *= bd
                    while (zero >= one) {
                        zero -= one
                        nm++
                    }
                    if (nm >= 10) {
                        nm -= 10
                        add += char[nm]
                    } else {
                        add += nm.toString()
                    }
                    if (str.length < 6) str += add
                }
            }

        } else {
            x = input.toBigIntegerOrNull(bases[0])
        }
        val num = x!!.toString(bases[1])
        println("Conversion result: $num$str")
        convert(bases, char)
    }
}






/*package converter

import java.math.RoundingMode
import java.math.BigDecimal
import java.math.BigInteger

fun main() {
    val char: CharArray = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    home(char)
}

fun home(char: CharArray) {
    print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
    val input = readLine()!!
    if (input == "/exit") return else if (input == "") home(char) else {
        val bases = input.split(" ").map { it.toInt() }
        convert(bases, char)
    }
}

fun convert(bases: List<Int>, char: CharArray) {
    print("Enter number in base ${bases[0]} to convert to base ${bases[1]} (To go back type /back) ")
    val input = readLine()!!
    if (input == "/back") home(char) else if (input == "") convert(bases, char) else {
        var x: BigInteger?
        var str = ""
        if (input.contains('.', true)) {
            x = input.substringBefore(".").toBigIntegerOrNull(bases[0])
            var zero = BigDecimal("0.00000")
            var br = true
            var y = input.substringAfter(".")
            var list = y.split("").filter { it != "" }
            var m: BigDecimal
            var n = BigDecimal.ONE.setScale(5, RoundingMode.UNNECESSARY)
            if (list.size > 0) {
                for (i in 0 until list.size) {
                    n /= bases[0].toBigDecimal().setScale(5, RoundingMode.UNNECESSARY)
                    if (list[i] !in char.map { it.toString() }) m = list[i].toBigDecimal().setScale(5, RoundingMode.UNNECESSARY)
                    else m = list.indexOfFirst { it.toString() == list[i] }.toBigDecimal().setScale(5, RoundingMode.UNNECESSARY) + BigDecimal("10").setScale(5, RoundingMode.UNNECESSARY)
                    zero += m * n
                }
            }
            zero.setScale(5, RoundingMode.HALF_UP)
            if (y.length < 1) br = false
            val bd = bases[1].toBigDecimal().setScale(5, RoundingMode.UNNECESSARY)
            var nm: Int
            var one = BigDecimal.ONE.setScale(5, RoundingMode.UNNECESSARY)
            var add = ""
            if (br) {
                str = "."
                for (i in 1..5) {
                    nm = 0
                    add = ""
                    zero *= bd
                    while (zero >= one) {
                        zero -= one
                        nm++
                    }
                    if (nm >= 10) {
                        nm -= 10
                        add += char[nm]
                    } else {
                        add += nm.toString()
                    }
                    if (str.length < 6) str += add
                }
            }

        } else {
            x = input.toBigIntegerOrNull(bases[0])
        }
        val num = x!!.toString(bases[1])
        println("Conversion result: $num$str")
        convert(bases, char)
    }
}

*/






/*
package converter
import java.math.BigInteger
import java.util.*
import kotlin.math.*


val testList = mutableListOf<String>()

var sourceBaseEx = BigInteger.valueOf(0)
var targetBaseEx = BigInteger.valueOf(0)
var inputNumberEx = ""

var sc = Scanner(System.`in`)

fun main() {

    for (i in 0..9) {
        testList.add(i.toString())
    }
    for (i in 'A'..'Z') {
        testList.add(i.toString())
    }

    print("Enter two numbers in format: {source base} {target base} " +
                "(To quit type /exit) > ")
    var str = sc.nextLine()
    if (str == "/exit"){
        System.exit(0)
    }else {
        sourceBaseEx = str.substringBefore(" ").toBigInteger()
        targetBaseEx = str.substringAfter(" ").toBigInteger()
    }
    subMenu ()


}

fun subMenu() {

    print("Enter number in base $sourceBaseEx to convert to base $targetBaseEx " +
            "(To go back type /back) > ")
  var  str = sc.nextLine()

   // if ()

    if (str == "/back") {
        main()
    }else{
        inputNumberEx = str.uppercase(Locale.getDefault()).toString()
    }


    workFun()
}


fun workFun() {

        var resultF = BigInteger.valueOf(0)
        var result = ""
    if (sourceBaseEx.toInt() == 10) {
       var inputNumberEx2 = inputNumberEx.toBigInteger()
        do {
            var (quotient, remainder) = inputNumberEx2.divideAndRemainder(targetBaseEx)
            result = testList[remainder.toInt()] + result
            inputNumberEx2 = quotient

        } while (quotient.toInt() != 0)
        if ((result[0].toString() == "0") &&
            (result.length >1)) result = result.substring(1)
        println("Conversion result: $result")
        subMenu()
    }else{

        //   from source Base to dec
        for (i in inputNumberEx.length - 1 downTo 0) {
            val targetPow = sourceBaseEx.toDouble()
            resultF += BigInteger.valueOf(
                (testList.indexOf(inputNumberEx[i].toString()) *
                        targetPow.pow(inputNumberEx.length - i - 1)).toLong()
            )
        }
     //   println(resultF)

        // to target base from dec

        var inputNumberEx2 = resultF
        do {
            var (quotient, remainder) = inputNumberEx2.divideAndRemainder(targetBaseEx)
            result = testList[remainder.toInt()] + result
            inputNumberEx2 = quotient

        } while (quotient.toInt() != 0)
   if ((result[0].toString() == "0") &&
       (result.length >1)) result = result.substring(1)
        println("Conversion result: $result")
    subMenu()

    }
}
*/
////////////////////////////

/*
package converter

const val PROMPT = "Enter two numbers in format: {source base} {target base} (To quit type /exit) "
const val CMD_EXIT = "/exit"
const val CMD_BACK = "/back"
const val RESULT = "Conversion result: "

fun main() {
    do {
        print(PROMPT)
        val cmd = readln()
        if (cmd != CMD_EXIT) {
            val lst: List<String> = cmd.split(" ")
            convertToAny(lst[0].toInt(), lst[1].toInt())
        }
    } while (cmd != CMD_EXIT)
}

fun convertToAny(srB: Int, tgB: Int) {
    do {
        print("Enter number in base $srB to convert to base $tgB (To go back type /back) ")
        val cmd = readln()
        if (cmd != CMD_BACK) {
            println(RESULT + cmd.toBigInteger(srB).toString(tgB))
        }
    } while (cmd != CMD_BACK)
}






*/








