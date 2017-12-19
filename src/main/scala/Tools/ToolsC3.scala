package Tools

import scala.collection.mutable.ArrayBuffer
import scala.util.{Random => r}

/**
  * Created by cubazis on 13.12.17.
  */
object ToolsC3 {
        implicit class IntExtended(n: Int) {
                def createIntArray: Array[Int] = { val b = (for (i <- 1 to n) yield i).toArray; b }

                def createRandomIntArrayBySeed(seed: Int): Array[Int] = { val r = new r(seed); val b = for (i <- 0 to n) yield r.nextInt(20)-10; b.toArray}

                def createRandomIntArray: Array[Int] = createRandomIntArrayBySeed(42)

                def createRandomDoubleArrayBySeed(seed: Int): Array[Double] = { val r = new r(seed); val b = for (i <- 0 to n) yield r.nextInt(20)-10 + r.nextDouble(); b.toArray}

                def createRandomDoubleArray: Array[Double] = createRandomDoubleArrayBySeed(42)

        }

        implicit class IntArrayExtended(a: Array[Int]) {
                def printa: Unit = println(a.mkString("< ", ", ", " >"))

                def jot: Array[Int] = {
                        val b = a.increaseSort
                        val unique = new ArrayBuffer[Int]
                        val duplicates = new ArrayBuffer[Int]
                        for (i <- b.indices) yield if(unique.contains(b(i))) {
                                duplicates.append(b(i))
                        }
                        else {
                                unique.append(b(i))
                        }
                        unique.diff(duplicates).toArray
                }

                def decreaseSort: Array[Int] = {a.toList.sortWith(_>_).toArray}

                def increaseSort: Array[Int] = {a.toList.sortWith(_<_).toArray}
        }

        implicit class IntArrayBufferExtended(ab: ArrayBuffer[Int]) {
                def printab: Unit = println(ab.mkString("< ", ", ", " >"))
        }

        implicit class DoubleArrayExtended(a: Array[Double]) {
                def printa: Unit = println(a.mkString("< ", ", ", " >"))

                def decreaseSort: Array[Double] = {a.toList.sortWith(_>_).toArray}

                def increaseSort: Array[Double] = {a.toList.sortWith(_<_).toArray}

                def mean: Double = a.sum/a.length
        }
}
