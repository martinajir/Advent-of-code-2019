@file:JvmName("Second")
import java.io.File

val bigList = listOf(1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,13,1,19,1,19,10,23,2,10,23,27,1,27,6,31,1,13,31,35,1,13,35,39,1,39,10,43,2,43,13,47,1,47,9,51,2,51,13,55,1,5,55,59,2,59,9,63,1,13,63,67,2,13,67,71,1,71,5,75,2,75,13,79,1,79,6,83,1,83,5,87,2,87,6,91,1,5,91,95,1,95,13,99,2,99,6,103,1,5,103,107,1,107,9,111,2,6,111,115,1,5,115,119,1,119,2,123,1,6,123,0,99,2,14,0,0)
val smallList = mutableListOf(1,0,0,0,99)
val smallList2 = mutableListOf(2,3,0,3,99)
val smallList3 = mutableListOf(2,4,4,5,99,0)
val smallList4 = mutableListOf(1,1,1,4,99,5,6,0,99)

var list : MutableList<Int> = mutableListOf()
var finalM : Int = 0
var finalN : Int = 0

fun main (args: Array<String>) {
    for (m in 0..99) {
        for(n in 0..99) {
            list = bigList.toMutableList()
            finalM = m
            finalN = n
            list[1] = m
            list[2] = n

            var i = 0
            while (i < list.size) {
                val opCode = list[i]
                performAction(opCode, i)
                i += 4
            }
        }
    }
    
}
    fun performAction(opCode: Int, index : Int) {
        when (opCode) {
            1 -> add(index)
            2 -> multiply(index)
            99 -> halt()
           // else -> println("unexpected opcode")
        }
    }

    fun add(index: Int){
        //println(list)
        val indexOfFirst = list[index+1]
        val indexOfSecond = list[index+2]
        val indexToPut = list[index+3]
        list[indexToPut] = list[indexOfFirst] + list[indexOfSecond]
    }

    fun multiply(index: Int) {
        //println(list)
        val firstToMultiply = list[index+1]
        val secondToMultiply = list[index+2]
        val indexToPut = list[index+3]
        list[indexToPut] = list[firstToMultiply] * list[secondToMultiply]
    }

    fun halt(){
       // println("loop ended")
        if(list[0] == 19690720){
            println("$finalM, $finalN")
            println(list)
        }
        else {
           // println("nope")
            //println(list[0])
        }
    }

