

object Chapter5 {
        def main(args: Array[String]): Unit = {
                println("Here are some practice code from the text of Chapter 5")
                repl()
                println("Here are tasks code from the end of Chapter 5")
                //tasks()
        }

        /** Here are tasks code from the end of Chapter 5 */
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

        /** Here are some practice code from the text of Chapter 5 */
        def repl(unit: Unit): Unit = {

                class Counter {
                        private var value = 0
                        def increment(): Unit = {
                                value += 1
                        }
                        def current() = value
                }

                val myCounter = new Counter()
                println("myCounter value: "+myCounter.current)
                myCounter.increment()
                println("myCounter value: "+myCounter.current)

        }
}
