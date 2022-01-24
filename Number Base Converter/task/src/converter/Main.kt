package converter
import java.math.BigInteger
import java.util.Scanner
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
        inputNumberEx = str.toString()
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

