import scala.collection.mutable.{HashMap => MutableMap}
import scala.collection.immutable.{SortedMap => ImmutableTreeMap}
import scala.collection.mutable.{TreeMap => MutableTreeMap}
import scala.collection.mutable.{LinkedHashMap => LinkedMap}

import Tools.ToolsC4._
/**
  * Created by cubazis on 13.12.17.
  */

object Chapter4 {
        def main(args: Array[String]): Unit = {
                println("Here are some practice code from the text of Chapter 4")
                //repl()
                println("Here are tasks code from the end of Chapter 4")
                tasks()
        }

        /** Here are tasks code from the end of Chapter 4 */
        def tasks(unit: Unit): Unit = {
                //task1()
                task2()
                //task3()
                //task4()
                //task5()
                //task6()
                //task7()
                //task8()
                //task9()
                //task10()
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
                val goods = Map("mandarins" -> 39.90, "Salad" -> 54.50, "Cherri Tomato" -> 45.50)
                goods.printmap()
        }

        def task3(unit: Unit): Unit = {
                println("Task 3")
        }

        def task4(unit: Unit): Unit = {
                println("Task 4")
        }

        def task5(unit: Unit): Unit = {
                println("Task 5")
        }

        def task6(unit: Unit): Unit = {
                println("Task 6")
        }

        def task7(unit: Unit): Unit = {
                println("Task 7")
        }

        def task8(unit: Unit): Unit = {
                println("Task 8")
        }

        def task9(unit: Unit): Unit = {
                println("Task 9")
        }

        def task10(unit: Unit): Unit = {
                println("Task 10")
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
