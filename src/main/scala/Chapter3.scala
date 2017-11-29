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
                println(array.mkString("< ", ", ", " >"))
                for (i <- array.indices) array(i) = i*2
                println(array.mkString("< ", ", ", " >"))

                println(array.mkString("< ", ", ", " >"))

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
                  * ++= method add whole array to buffer
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


                /** a miserable function for printing arrays */
                def ArrayPrint(a: Array[Int]): Unit = {
                        print("< ")
                        for (i <- a.indices) if(i != a.length-1)print(a(i)+", ") else print(a(i)+" >\n")
                }
        }
}
