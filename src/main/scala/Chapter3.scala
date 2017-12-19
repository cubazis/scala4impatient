import scala.collection.mutable.ArrayBuffer
import ToolsC3._
import java.util.TimeZone.getAvailableIDs
import java.awt.datatransfer._
import scala.collection.JavaConverters._
import scala.collection.mutable.Buffer


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
        def tasks(unit: Unit): Unit = {
                task1()
                task2()
                task3()
                task4()
                task5()
                task6()
                task7()
                task8()
                task9()
                task10()
        }




        def task1(unit: Unit): Unit = {
                println("Task 1")
                println(func(5).mkString("< ", ", ", " >"))
                def func(n: Int): Array[Int] = { val b = (for (i <- 0 until n) yield i).toArray; b }
        }

        def task2(unit: Unit): Unit = {
                println("Task 2")
                var a: Array[Int] = null
                a = 5.createIntArray
                println(a.mkString("< ", ", ", " >"))
                a = swapPairInArray(a)
                println(a.mkString("< ", ", ", " >"))

                a = 6.createIntArray
                println(a.mkString("< ", ", ", " >"))
                a = swapPairInArray(a)
                println(a.mkString("< ", ", ", " >"))

                def swapPairInArray(a: Array[Int]) : Array[Int] = {
                        var i = 1
                        var temp = 0
                        while (i < a.length){
                                temp = a(i-1)
                                a(i-1) = a(i)
                                a(i) = temp
                                i += 2
                        }
                        a
                }
        }

        def task3(unit: Unit): Unit = {
                println("Task 3")
                def swapPairInArray(a: Array[Int]): Array[Int] = {val b = (for (i <- a.indices) yield if (i % 2 == 1) a(i - 1) else if (i != a.length-1) a(i+1) else a(i)).toArray; b}
                def swapPairFP(a: Array[Int]): Array[Int] = { val b = (1 to a.length).iterator.sliding(2, 2).map(x => Array(x.last, x.head).distinct).flatten.toArray; b}

                def demo(n: Int): Unit = {
                        println(n.createIntArray.mkString("< ", ", ", " >"))
                        println(swapPairInArray(n.createIntArray).mkString("< ", ", ", " >"))
                }
                //in functional style
                def fdemo(n: Int): Unit = {
                        println(n.createIntArray.mkString("< ", ", ", " >"))
                        println(swapPairFP(n.createIntArray).mkString("< ", ", ", " >"))
                }

                demo(5); fdemo(5)
                demo(6); fdemo(6)

        }

        def task4(unit: Unit): Unit = {
                println("Task 4")
                val a = 10.createRandomIntArrayBySeed(25)
                a.printa
                a.decreaseSort.printa
                a.increaseSort.printa

                def getByIndeces(ab: ArrayBuffer[Int], a: Array[Int]): ArrayBuffer[Int] = {
                        val b = for (i <- ab) yield a(i)
                        b
                }

                def positiveFirst(a: Array[Int]): Array[Int] = {
                        val p, n, z = new ArrayBuffer[Int]
                        for (i <- a.indices) if (a(i) > 0) {p += i} else if (a(i) == 0) {z += i} else {n += i}
                        val res = new ArrayBuffer[Int]
                        res.++=(getByIndeces(p, a)).++=(getByIndeces(z, a)).++=(getByIndeces(n, a)).toArray
                }

                def positiveFirstSort(a: Array[Int]): Array[Int] = {
                        val p, n, z = new ArrayBuffer[Int]
                        for (i <- a.indices) if (a(i) > 0) {p += i} else if (a(i) == 0) {z += i} else {n += i}
                        val res = new ArrayBuffer[Int]
                        res.++=(getByIndeces(p, a).toList.sortWith(_<_).toBuffer)
                        res.++=(getByIndeces(z, a).toList.sortWith(_<_).toBuffer)
                        res.++=(getByIndeces(n, a).toList.sortWith(_<_).toBuffer)
                        res.toArray
                }
                positiveFirst(a).printa
                positiveFirstSort(a).printa
        }

        def task5(unit: Unit): Unit = {
                println("Task 5")
                val a = 10.createRandomDoubleArray
                a.printa
                println(a.sum/a.length)
                println(a.mean)
        }

        def task6(unit: Unit): Unit = {
                println("Task 6")
                val a = 10.createRandomIntArray
                a.printa
                a.reverse.printa
                val ab = ArrayBuffer(4, 8, 15, 16, 23, 42)
                ab.printab
                ab.reverse.printab
        }

        def task7(unit: Unit): Unit = {
                println("Task 7")
                val a = Array(1, 3, 4, 3, 8, 15, 9, 1, 16, 7, 23, 7, 2, 42, 2, 9)
                a.printa
                a.distinct.printa
                a.jot.printa
        }

        /** What is the point of this task. I don't know */
        def task8(unit: Unit): Unit = {
                println("Task 8")
                val a = ArrayBuffer[Int](1, 2, -1, 3, 4, -2, 5, -3, 6)
                var indexes = for (i <- a.indices if a(i) < 0) yield i
                indexes = indexes.reverse.dropRight(1)
                for (j <- indexes) a.remove(j)
                a.printab
        }

        def task9(unit: Unit): Unit = {
                println("Task 9")
                val zones = getAvailableIDs
                val filtered = zones.diff(zones.filter(_.startsWith("America/")))

                val usa = zones.filter(_.startsWith("America/")).map( (s) => s.stripPrefix("America/")).sorted
                println(usa.mkString(", "))

        }

        /** What's going on here?*/
        def task10(unit: Unit): Unit = {
                println("Task 10")
                val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]

                val nativesForFlavors = flavors.getNativesForFlavors(Array(DataFlavor.imageFlavor))

                val vals = collection.JavaConversions.asScalaBuffer(new java.util.LinkedList(nativesForFlavors.values()))
                println(vals)

        }

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
