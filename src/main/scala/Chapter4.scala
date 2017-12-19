/**
  * Created by cubazis on 13.12.17.
  */

object Chapter4 {
        def main(args: Array[String]): Unit = {
                println("Here are some practice code from the text of Chapter 4")
                repl()
                println("Here are tasks code from the end of Chapter 4")
                //tasks()
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
        }

        def task2(unit: Unit): Unit = {
                println("Task 2")
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
                /** my first map in Scala*/
                val lost = Map(
                        4 -> "Locke",
                        8 -> "Reyes",
                        15 -> "Ford",
                        16 -> "Jarrah",
                        23 -> "Shephard",
                        42 -> "Kwon"
                )
                lost foreach(x => print (x._1 + " -> " + x._2 + ", "))
        }
}
