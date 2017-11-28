import scala.math.BigInt.probablePrime
import scala.util.Random

/**
  * Created by cubazis on 25.11.17.
  */
object Chapter1 {
        def main(args: Array[String]): Unit = {
                repl()
                //tasks()
        }


        /** Here are some practice code from the text of Chapter 1 */
        def repl(unit: Unit) : Unit = {
                /** MustKnow: 'scala' program isn't interpretator,
                  * but use fast compilation  behind
                  */
                val res0 = 8*5
                println(res0)

                val res1 = 42
                val res2 = "Text" + " " + res1
                println(res2)

                println(res2.toCharArray)

                for (i <- res2.toCharArray) print(i+" ")
                println()

                println(res2.toLowerCase)
                println(res2.toString)
                println(res2.toUpperCase)

                /** res0 = 42 //Reassignment of 'val' is not appropriate
                 but it's appropriate for 'var' */
                var res3 = 1
                println(res3)
                res3 = 42
                println(res3)

                /** Note, that it isn't necessary to declare type,
                  * this happens automatically from the initialization expression
                  * but then we will use strict form of declaration with type
                  */
                var str : String = "just a string"
                println(str)

                /** But we can't declare without initialization*/
                //var str : String
                //or
                //val str : String


                /** it's appropriate to declare several vals/vars in one declaration */
                val x, y = 42
                println(x +" "+ y)

                /** Note that such code is not right*/
                //var x = y = 42

                /** There is no wrapper types in Scala. All these things compilator does*/

                /** intersect() method belongs to StringOps class,
                  * so at first String will be changed into StringOps
                  * and then method will be called
                  */
                println("Hello".intersect("World"))

                /** operator overloading */
                println(2 + 3)
                //same thing
                println(2.+(3))

                println(1.to(5))
                //same thing
                println(1 to 5)

                /** methods without parameters */
                println("Hello".distinct)

                /** method apply */
                println("Hello"(4))
                //same
                println("Hello".apply(4))

                /** apply method is a typical form of object constructing in Scala
                  * it means that 'new' key word is not necessary
                  */
                println(BigInt("42") * BigInt("42"))
                //or
                for (i <- Array(1, 4, 8, 8)) print(i + " ")
                println()

                /** ScalaDoc */
                // TODO: https://github.com/swagger-api/swagger-scala-module
        }

        /** Here are tasks code from the end of Chapter 1 */
        def tasks(unit: Unit) : Unit = {
                task1()
                task2()
                // res variables are VAL
                task4()
                task5()
                task6()
                task7()
                task8()
                task9()
                task10()
        }

        /** Task 1: методы применимые к числу 3*/
        def task1(unit: Unit) : Unit = {
                println("Result of mod 3.%(2) = "+3.%(2))
                println("Result of mod 3%2 = "+3%2)
                println("Result of xor 3.^(2) = "+3.^(2))
                println("Result of xor 3.^(1) = "+3.^(1))
                println("Result of 3.toChar = "+3.toChar)
                println("Result of 3.isInstanceOf[Int] = "+3.isInstanceOf[Int])
                println("Result of 3.isInstanceOf[Char] = "+3.isInstanceOf[Char])
                println("Result of 3.asInstanceOf[Char] = "+3.asInstanceOf[Char])
        }

        def task2(unit: Unit) : Unit = {
                println(3 - math.pow(math.sqrt(3), 2))
        }

        def task4(unit: Unit) : Unit = {
                var kek = "kek"*2 // Can be found in the StringOps class
                println(kek)
                kek = kek.patch(0, "lol", 3)
                println(kek)
        }

        def task5(unit: Unit) : Unit = {
                println("10 max 3: "+(10 max 3))
                println("10.max(3): "+10.max(3))
                println("10 min 3: "+(10 min 3))
                println("10.min(3): "+10.min(3))
        }

        def task6(unit: Unit) : Unit = {
                println("BigInt(2).pow(1024): "+BigInt(2).pow(1024))
                println("BigInt(2) pow 1024: "+(BigInt(2) pow 1024))
        }

        def task7(unit: Unit) : Unit = {
                println(probablePrime(100, Random))
        }

        def task8(unit: Unit) : Unit = {
                println(probablePrime(100, Random).toString(36)) //Convert BigInt to base 36
        }

        def task9(unit: Unit) : Unit = {
                val str = "String"
                println("First symbol of 'String' word: "+str.head)
                println("First symbol of 'String' word: "+str(0))
                println("Last symbol of 'String' word: "+str.last)
                println("Last symbol of 'String' word: "+str(str.length - 1))
        }

        def task10(unit: Unit) : Unit = {
                var str: String = "kek"
                println("take: Selects the first n elements")
                println("str.take(0) "+str.take(0))
                println("str.take(1) "+str.take(1))
                println("str.take(2) "+str.take(2))
                println("str.take(3) "+str.take(3))
                println("drop: Selects all elements except first n ones")
                println("str.drop(0) "+str.drop(0))
                println("str.drop(1) "+str.drop(1))
                println("str.drop(2) "+str.drop(2))
                println("str.drop(3) "+str.drop(3))
                println("takeRight: Selects the last n elements")
                println("str.takeRight(0) "+str.takeRight(0))
                println("str.takeRight(1) "+str.takeRight(1))
                println("str.takeRight(2) "+str.takeRight(2))
                println("str.takeRight(3) "+str.takeRight(3))
                println("dropRight: Selects all elements except last n ones")
                println("str.dropRight(0) "+str.dropRight(0))
                println("str.dropRight(1) "+str.dropRight(1))
                println("str.dropRight(2) "+str.dropRight(2))
                println("str.dropRight(3) "+str.dropRight(3))
        }
}
