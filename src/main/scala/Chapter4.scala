import java.io.File
import java.util.Scanner

import scala.collection.mutable.{HashMap => MutableMap}
import scala.collection.immutable.{SortedMap => ImmutableTreeMap}
import scala.collection.mutable.{TreeMap => MutableTreeMap}
import scala.collection.mutable.{LinkedHashMap => LinkedMap}
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import Tools.ToolsC4._

/**
  * Created by cubazis on 13.12.17.
  */

object Chapter4 {
        def main(args: Array[String]): Unit = {
                println("Here are some practice code from the text of Chapter 4")
                repl()
                println("Here are tasks code from the end of Chapter 4")
                tasks()
        }

        /** Here are tasks code from the end of Chapter 4 */
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
                val goods = Map("mandarins" -> 39.90, "Salad" -> 54.50, "Cherri Tomato" -> 45.50)
                goods.printmap
                val goods_deprices = for((k,v)<-goods) yield (k, v*0.9)
                goods_deprices.printmap
        }

        def task2(unit: Unit): Unit = {
                println("Task 2")
                val in = new Scanner(new File("store/test.txt"))
                val map = new MutableMap[String, Int]
                while (in.hasNext) {
                        val w = in.next()
                        map(w) = map.getOrElse(w, 0) + 1
                }
                map.printmap()
        }

        def task3(unit: Unit): Unit = {
                println("Task 3")
                val in = new Scanner(new File("store/test.txt"))
                var map = Map[String, Int]()
                while (in.hasNext) {
                        val w = in.next()
                        map += (w -> (map.getOrElse(w, 0) + 1))
                }
                map.printmap()
        }

        def task4(unit: Unit): Unit = {
                println("Task 4")
                val in = new Scanner(new File("store/test.txt"))
                var map = ImmutableTreeMap[String, Int]()
                while (in.hasNext) {
                        val w = in.next()
                        map += (w -> (map.getOrElse(w, 0) + 1))
                }
                map.printmap()
        }

        def task5(unit: Unit): Unit = {
                println("Task 5")
                val in = new Scanner(new File("store/test.txt"))
                var map: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
                while (in.hasNext) {
                        val w = in.next()
                        map(w) = map.getOrElse(w, 0) + 1
                }
                map.foreach(x => print(x._1+" -> "+x._2))
        }

        def task6(unit: Unit): Unit = {
                println("Task 6")
                val map = scala.collection.mutable.LinkedHashMap(
                        "Monday" -> java.util.Calendar.MONDAY,
                        "Tuesday" -> java.util.Calendar.TUESDAY,
                        "Wednesday" -> java.util.Calendar.WEDNESDAY,
                        "Thursday" -> java.util.Calendar.THURSDAY,
                        "Friday" -> java.util.Calendar.FRIDAY,
                        "Saturday" -> java.util.Calendar.SATURDAY,
                        "Sunday" -> java.util.Calendar.SUNDAY
                )
                map.foreach(x => print(x._1+" -> "+x._2+", ")); println()
        }

        def task7(unit: Unit): Unit = {
                println("Task 7")
                val props: scala.collection.Map[String, String] = System.getProperties()
                var maxk = 0
                props.keys.foreach(k => maxk = maxk max k.length)
                for((k, v) <- props) println(k.padTo(maxk, ' ') + " | " + v)
        }

        def task8(unit: Unit): Unit = {
                println("Task 8")
                def minmax(values: Array[Int]):(Int, Int) = (values.min, values.max)
                val ar = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                println(minmax(ar))
        }

        def task9(unit: Unit): Unit = {
                println("Task 9")
                def lteqgt(values: Array[Int], v:Int):(Int, Int, Int) = {
                        var lt = 0
                        var eq = 0
                        var gt = 0
                        values.foreach(x => if(x < v) lt += 1 else if (x == v) eq += 1 else gt += 1)
                        (lt, eq, gt)
                }
                val ar = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                println(lteqgt(ar, 5))
        }

        def task10(unit: Unit): Unit = {
                println("Task 10")
                println("Hello".zip("World"))
        }

        /** Here are some practice code from the text of Chapter 4 */
        def repl(unit: Unit): Unit = {
                /** my first map in Scala
                  *  lost is a scala.collection.immutable.Map[Int, String]
                  */
                val lost = Map(
                        4 -> "Locke",
                        8 -> "Reyes",
                        15 -> "Ford",
                        16 -> "Jarrah",
                        23 -> "Shephard",
                        42 -> "Kwon"
                )
                lost foreach(x => print (x._1 + " -> " + x._2 + ", "))
                println()

                val mutableMap1: MutableMap[Int, String] = MutableMap((1, "one"), (2, "two"))
                mutableMap1 foreach(x => print (x._1 + " -> " + x._2 + ", ")); println()

                val locke1 = if(lost.contains(4)) lost(4) else "Mr.Nobody"
                val locke2 = if(lost.contains(5)) lost(5) else "Mr.Nobody"
                val locke3 = lost.getOrElse(4, "Mr.Nobody")
                println(locke1, locke2, locke3)
                println(lost.get(4))

                mutableMap1(5) = "five"
                mutableMap1 foreach(x => print (x._1 + " -> " + x._2 + ", ")); println()

                mutableMap1 += (6 -> "six", 7-> "seven")
                mutableMap1 foreach(x => print (x._1 + " -> " + x._2 + ", ")); println()
                mutableMap1 -= 6
                mutableMap1 foreach(x => print (x._1 + " -> " + x._2 + ", ")); println()

                val mapa = Map("1"->"one", "2"->"two")
                for ((k,v) <- mapa) print(k+" -> "+v+" "); println

                for(k <- mapa.keys) print(k+" "); println
                for(ks <- mapa.keySet) print(ks+" "); println
                for(v <- mapa.values) print(v+" "); println
                val mapa2 = for ((k,v) <- mapa) yield (v,k)
                for ((k,v) <- mapa2) print(k+" -> "+v+" "); println

                val immutable_tree_map = ImmutableTreeMap("1"->"one", "2"->"two")
                for ((k,v) <- immutable_tree_map) print(k+" -> "+v+" "); println
                val mutable_tree_map = MutableTreeMap("1"->"one", "2"->"two")
                for ((k,v) <- mutable_tree_map) print(k+" -> "+v+" "); println
                val mutable_linked_map  = LinkedMap("1"->"one", "2"->"two")
                for ((k,v) <- mutable_linked_map) print(k+" -> "+v+" "); println

                val tuple3 = (1, 3.14, "Pi")
                println(tuple3)
                println(tuple3._2)
                val (integer, double, _) = tuple3
                println(integer+double)
                println("Happy New Year".partition(_.isUpper))

                val symbols = Array("<", "-",">")
                val counts = Array(2,7,2)
                val pairs = symbols.zip(counts)
                for((s, n) <- pairs) print(s*n); println
        }
}
