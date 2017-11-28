/**
  * Created by cubazis on 28.11.17.
  */
import scala.io.{StdIn => in}
import scala.util.control.Breaks._

object Chapter2 {
        def main(args: Array[String]): Unit = {
                println("Here are some practice code from the text of Chapter 2")
                repl()
                println("Here are tasks code from the end of Chapter 2")
                //tasks()

                //func_for()
                //func_name_age()
                //func_functions()


        }

        def repl(unit: Unit): Unit = {
                /** printing Hebrew alphabet. sic! Scala shell print it from left to right,
                  *  but in IntelliJ project something strange happens
                  */
                for (i <- 1488 to 1514) print(i.toChar + " ")
                println()

                func_if_else()


        }

        def tasks(unit: Unit): Unit = {
                task1()
                task2()
                task3()
                task4()
                task5()
                task6()
                task7()
                //task8 is already done as a function
                task9()
                task10()
        }

        def task10():Unit = {
                def xpown(x: BigDecimal, n: Int): BigDecimal = {
                        if (n == 0) 1
                        else if (n < 0) 1 / xpown(x, -n)
                        else if (n % 2 == 0) {
                                val i = xpown(x, n / 2)
                                i * i
                        }
                        else x * xpown(x, n - 1)
                }
                xpown(2, 1024)
                xpown(-2, -10)
                xpown(-2, 10)
        }

        def task9():Unit = {
                def unicode_prodaction(str: String): BigInt = {
                        if(str.length == 0) 1 else str.head * unicode_prodaction(str.tail)
                }
                println(unicode_prodaction("Hello"))
        }

        def task7():Unit = {
                def unicode_prodaction(str: String): BigInt = {
                        str.foldLeft(1: BigInt)((a, b) => a * b.toInt)
                }
                println(unicode_prodaction("Hello"))
        }

        def task6():Unit = {
                def unicode_prodaction(str: String): BigInt = {
                        var prod: BigInt = 1
                        for(c <- "Hello") prod *= c.toInt
                        prod
                }
                println(unicode_prodaction("Hello"))
        }

        def task5():Unit = {
                def countdoun(n:Int): Unit ={
                        for(i <- n.to(0, -1)) println(i)
                }
                countdoun(5)
        }

        def task4():Unit = {
                for (i <- 10.to(0, -1)) println(i)
        }

        def task3():Unit = {
                var y = 0
                val x:Unit = y = 1
                println(x)
                println(x.isInstanceOf[Unit])
        }

        def task2():Unit = {
                val blank = {}
                println(blank)
                println(blank.getClass)
                println(blank.isInstanceOf[Unit])
        }

        def task1():Unit = {
                def signum(n:Int) = {
                        if(n > 0) 1 else if (n < 0) -1 else 0
                }
                println(signum(-42))
                println(signum(42))
                println(signum(0))
        }



        def func_functions(): Unit = {

                def template(){
                        println("kek")
                }

                def sum(args: Int*):Int = {
                        var result = 0
                        for (arg <- args){
                                result += arg
                        }
                        result
                }

                def decorate(str: String, l:String = "[", r:String = "]"):String = {
                        l+str+r
                }

                def fac(n:Int) = {
                        var r = 1
                        if(n <= 0){
                                1
                        } else {
                                for (i <- 1.to(n)) r = r*i
                                r
                        }
                }

                def fac_recc(n:Int): Int = {
                        if(n <= 0) 1 else n*fac_recc(n-1)
                }
                //val x = in.readLine("Enter integer value: ")
                val x = 5
                println(fac(x.toInt))
                println(fac_recc(x.toInt))
                println(decorate(5.toString, "<", ">"))
                println(decorate(5.toString))
                var ints: Array[Int]= Array(1,2,3)
                // Elegant
                println(sum(ints: _*))
                val kek = template()
                println(kek)
                val x1 = 5
                lazy val x2 = 5
                def x3 = 5
                println(x1, x2, x3)

        }



        def func_for():Unit = {
                val line = in.readLine("Enter your shit: ")
                for (i <- 1.to(10)){
                        print(i+" ")
                }
                println()
                var i = 0
                for (c <- line){
                        print(c)
                        i += 1
                        if(i < line.length) print(" ")
                }
                println()
                var sum = 0
                for (i <- 0 until line.length){
                        print(line(i).toInt +" ")
                        sum += line(i)
                }
                println("\n"+sum)
                breakable{
                        for (i <- 0 until line.length){
                                if(line(i) == 'e'){
                                        println("stop")
                                        break
                                }
                                print(line(i).toInt +" ")
                        }
                }
                for (i <- 1 to 3; from = 4 - i; j <- from to 3){
                        print((10*i+j)+" ")
                }
                println()
                val vec = for (i <- 97.to(99)) yield i.toChar
                println(vec)
        }

        def func_if_else():Unit = {
                breakable {
                        while (true) {
                                var input = in.readLine("Enter '1' or '2' or '3'")
                                val res = if (input == "1") 1488 else if (input == "2") 1337 else break
                                println(res)
                        }
                }
        }

        def func_name_age():Unit = {
                val name = in.readLine("Enter name: ")
                print("Your age: ")
                val age = in.readInt()
                println(name+" is "+age+" years old")
        }
}
