import scala.collection.mutable.ArrayBuffer

/**
  * Created by cubazis on 28.11.17.
  */
object Chapter3 {
        def main(args: Array[String]): Unit = {
                println("Here are some practice code from the text of Chapter 3")
                repl()
                println("Here are tasks code from the end of Chapter 3")
                tasks()
        }

        /** Here are tasks code from the end of Chapter 3 */
        def tasks(unit: Unit): Unit = {}

        /** Here are some practice code from the text of Chapter 3 */
        def repl(unit: Unit): Unit = {

                /** immutable arrays are Java-arrays under JVM
                  * Array[Int] is int[] Array[String] java.lang.String[]
                  */

                val array = new Array[Int](7)
                println(array(0))
                println(array.mkString("< ", ", ", " >"))
                for (i <- array.indices) array(i) = i*2
                println(array.mkString("< ", ", ", " >"))

                println((for (i <- array.indices if i % 2 == 0) yield 2 * array(i)).mkString("< ", ", ", " >"))

                //sila
                println(array.filter(_ % 2 == 0).map(2 * _).mkString("< ", ", ", " >"))

                val s = Array("First", "Second", "Third")
                println(s.mkString("< ", ", ", " >"))

                val buffer = new ArrayBuffer[Int]()

                println(buffer.mkString("< ", ", ", " >"))
                /** += is actually a method, not an assignment
                  * that's why we can do it with buffer which is val
                  * val - immutable, but += does not change val, not assign it
                  * */
                buffer += 4
                println(buffer.mkString("< ", ", ", " >"))

                /** Look here! It's cool
                  * ++= method add ANY COLLECTION to buffer
                  */
                buffer ++= Array(8, 15, 16, 23, 42)
                println(buffer.mkString("< ", ", ", " >"))

                /** Amazing! same but without Array constructor */
                val buffer1 = new ArrayBuffer[Int]()
                buffer1 += (4, 8, 15, 16, 23, 42)
                println(buffer1.mkString("< ", ", ", " >"))

                buffer1.trimStart(1)
                buffer1.trimEnd(1)
                println(buffer1.mkString("< ", ", ", " >"))
                println(buffer1.takeRight(1))

                buffer1.insert(2, 3, 4, 5)
                println(buffer1.mkString("< ", ", ", " >"))

                buffer1.remove(2, 2)
                println(buffer1.mkString("< ", ", ", " >"))

                val b2a = buffer.toArray
                println(buffer.isInstanceOf[ArrayBuffer[Int]])
                println(b2a.isInstanceOf[Array[Int]])

                val buffer2 = b2a.toBuffer
                println(buffer2.isInstanceOf[ArrayBuffer[Int]])

                /** array traversal */

                val b = ArrayBuffer(4, 8, 15, 16, 23, 42)
                println(b.mkString(" "))

                for (i <- b.indices) print(b(i)+" ")
                println()

                for (i <- 0 until b.length) print(b(i)+" ")
                println()

                for (i <- 0 until (b.length,2)) print(b(i)+" ")
                println()

                //sila
                for (i <- (0 until (b.length,2)).reverse) print(b(i)+" ")
                println()

                /** array transforming */
                val seq = ArrayBuffer(-7,2,-1,-4,3)

                /** collect indexes of positive sequence elements */
                var first = true
                val indexes = for (i <- seq.indices if first || seq(i) >= 0) yield {
                        if(seq(i) < 0) first = false; i
                }
                //println(indexes.mkString("< ", ", ", " >"))

                for (j <- indexes.indices) seq(j) = seq(indexes(j))
                println(seq.mkString("< ", ", ", " >"))

                //trim other elements
                seq.trimEnd(seq.length - indexes.length)
                println(seq.mkString("< ", ", ", " >"))

                /** main algorithms */
                val sBuffer1 = ArrayBuffer(1, 3, 4, 7, 3, 9, 3, 8)
                val sBuffer2 = sBuffer1.sorted
                println(sBuffer2.mkString("< ", ", ", " >"))

                /** multidimensional arrays */
                val matrix = Array.ofDim[Double](2, 2)
                matrix(0)(0) = 1
                matrix(0)(1) = 2
                matrix(1)(0) = 2
                matrix(1)(1) = 1
                println(matrix(0)(0) + " " + matrix(0)(1))
                println(matrix(1)(0) + " " + matrix(1)(1))


                /** a miserable function for printing arrays */
                def ArrayPrint(a: Array[Int]): Unit = {
                        print("< ")
                        for (i <- a.indices) if(i != a.length-1)print(a(i)+", ") else print(a(i)+" >\n")
                }
        }
}
