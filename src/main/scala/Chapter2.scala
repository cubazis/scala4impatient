/**
  * Created by cubazis on 28.11.17.
  */
import scala.io.{StdIn => in}
import scala.util.control.Breaks._
import scala.math.sqrt
import scala.math.pow

object Chapter2 {
        def main(args: Array[String]): Unit = {
                println("Here are some practice code from the text of Chapter 2")
                repl()
                println("Here are tasks code from the end of Chapter 2")
                //tasks()
        }

        def repl(unit: Unit): Unit = {
                //proc_hebrew()
                //func_name_age()
                //func_if_else()
                //func_demonstrates_types()
                //func_demonstrates_scope()
                //func_demonstrates_for()
                //proc_functions_features("procedure")
                proc_exception()
        }

        /** just to demonstrate an exception */
        def proc_exception() {
                def exception(x: Int) {
                        if (x < 3) {
                                println(x)
                        }
                        else {throw new Exception("This is Exception")}
                }

                val int0 = 5
                try {
                        exception(int0)
                } catch {
                        case e: Exception => println(e)
                }
        }


        /** just to demonstrate functions features
          * method links with object, but not function
          * in Java functions are imitated by static methods
          *
          * look at func_functions_features, this is procedure, which does not return any value
          * that's why we don't have to use "=" in declaration
          * procedure returns "Unit" type
          * */
        def proc_functions_features(str: String) {

                println("now we are in a "+str)

                /** nested functions */
                def template(){
                        println("kek")
                }

                val kek = template()
                println(kek)

                /** in non-recurrent functions type has to be declared */
                def fac(n:Int) = {
                        var r = 1
                        if(n <= 0){
                                1
                        } else {
                                for (i <- 1.to(n)) r = r*i
                                r
                        }
                }

                /** in recurrent functions type has to be declared */
                def fac_recc(n:Int): Int = {
                        if(n <= 0) 1 else n*fac_recc(n-1)
                }

                val x = 5
                println(fac(x.toInt))
                println(fac_recc(x.toInt))

                /** default arguments */
                def decorate(str: String, l:String = "[", r:String = "]"):String = {
                        l+str+r
                }

                //call function with default values
                println(decorate(5.toString))
                //call function with your named values
                println(decorate(l = "<", str = 5.toString, r = ">"))
                //another call function with your unnamed values
                println(decorate(5.toString, "(", ")"))

                /** scope has value of a last string of this scope
                  * function with variable number of arguments "sum(args: Int*)"
                  * Int* is a Seq type
                  * */
                def sum(args: Int*):Int = {
                        var result = 0
                        for (arg <- args){
                                result += arg
                        }
                        result
                }

                val ints1: Array[Int] = Array(1, 2, 3)
                // Elegant
                println(sum(ints1: _*))

                //same
                val s = sum(1 to 3: _*)
                println(sum(s))

                /** recurrent sum function to demonstrate work with Seq type */
                def reccSum(args: Int*): Int = {
                        if (args.isEmpty) 0
                        else args.head + reccSum(args.tail: _*)
                }

                // result = 6
                println(reccSum(1 to 3: _*))
                // result = 15
                println(reccSum(1 to 5: _*))

                /** val, lazy val, def*/

                /** initialisation is done with declaration*/
                val x1 = 5

                /** initialisation will be done when program will call x2*/
                lazy val x2 = 5

                /** initialisation will be done with each call x3*/
                def x3 = 5
                println(x1, x2, x3)
        }

        /** just to demonstrate for cycle features */
        def func_demonstrates_for():Unit = {
                val line = in.readLine("Enter your string with 'e' letter: ")
                // this 'for (i <- expr)' ensure that sequential assignment
                // type of i defined by type of collection after <- symbol
                for (i <- 1.to(10)){
                        print(i+" ")
                }
                println()

                var sum = 0

                var i = 0
                for (c <- line){ // collection has string type
                        print(c)
                        sum += c // but here we can summarize without transformation to Int
                        i += 1
                        if(i < line.length) print(" ")
                }
                println("\nSum: "+sum)

                sum = 0
                for (i <- 0 until line.length){ // collection has string type
                        print(line(i).toInt +" ")
                        sum += line(i) // but here we can summarize without transformation to Int
                }
                println("\nSum: "+sum)

                /** break excites an exception, so avoid this if execution speed is critical
                  * good old while loop control via additional variables
                  */
                breakable{
                        for (i <- 0 until line.length){
                                if(line(i) == 'e'){
                                        println("stop")
                                        break
                                }
                                print(line(i).toInt +" ")
                        }
                }

                /** extended for */
                for (i <- 1 to 3; from = 4 - i; j <- from to 3){
                        print((10*i+j)+" ")
                }
                println()

                /** yield constructs collection
                  * for instance this returns Vector()
                  */
                val vec = for (i <- 97.to(99)) yield i.toChar
                println(vec)
        }

        /** just to demonstrate scope features*/
        def func_demonstrates_scope(): Unit = {
                val x0, y0 = 0
                val x = 3; val y = 4
                println({lazy val dx = x - x0; lazy val dy = y - y0; sqrt(pow(dx, 2) + pow(dy, 2))})
        }

        /** just to demonstrate features of types */
        def func_demonstrates_types(): Unit = {
                val num1 = in.readLine("Enter number: ")
                println(if (num1.toInt > 3) 1 else -1)

                //same

                val num2 = in.readLine("Enter number again: ")
                var check: Int = 0
                if (num2.toInt > 3) check = 1 else check = -1
                println(check)

                val num3 = in.readLine("And again: ")
                // here if/else statement has type of supertype 'Any'
                println(if (num3.toInt > 3) "something" else 1)

                //if num3 > 3 it can turn out that we do not have type
                // in this case 'Unit' type helps
                println(if (num3.toInt < 3) 42)
                //same
                println(if (num3.toInt < 3) 42 else ())
                // () is the only one value of 'Unit' type
                // that is why Unit != void type, void does not have any values
        }

        /** just to work with scala.io.{StdIn => in} */
        def func_name_age(): Unit = {
                val name = in.readLine("Enter name: ")
                print("Your age: ")
                val age = in.readInt()
                println(name+" is "+age+" years old")
        }

        /** if else statement has value too
          * break construct is used thought scala.util.control.Breaks._ with breakable scope and "break" function
          * break excites an exception, so avoid this if execution speed is critical
          * good old while loop control via additional variables
          */
        def func_if_else():Unit = {
                breakable {
                        while (true) {
                                val input = in.readLine("Enter '1' or '2' or '3'")
                                val res = if (input == "1") 1488 else if (input == "2") 1337 else break
                                println(res)
                        }
                }
        }

        /** printing Hebrew alphabet. sic! Scala shell print it from left to right,
          *  but in IntelliJ project something strange happens
          */
        def proc_hebrew() {
                for (i <- 1488 to 1514) print(i.toChar + " ")
                println()
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
}
