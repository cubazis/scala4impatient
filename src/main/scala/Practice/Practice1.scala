package Practice

object Practice1 {
        def main(args: Array[String]): Unit = {
                //example1()
                //example2()
                //example3()
                //example4()
                example5()

        }

        def example5(unit: Unit):Unit = {
                abstract class User

                case class KnownUser(val name: String) extends User

                case class AnonymousUser() extends User

                case class UFO() extends User

                val users = List(KnownUser("Mark"), AnonymousUser(), KnownUser("Phil"), UFO())

                def register(user: User): Unit = user match {
                        case KnownUser(name) => println("User " + name + " registered")
                        case AnonymousUser() => println("Anonymous user can't be registered")
                        case _ => println("UFO flew in and published this inscription here")
                }

                users.foreach( register )
        }

        def example4(unit: Unit):Unit = {
                class User(str: String = "_") {
                        private[this] var _name: String = str
                        def name = _name toUpperCase
                        def name_=(name: String) = {
                                _name = if (name != null) name else ""
                        }
                }


                val user = new User("Scala!!!")
                println(user.name)
                user.name = "M. Odersky"
                println(user.name)
                val user2 = new User
                println(user2.name)
        }

        def example3(unit: Unit):Unit = {
                class Complex(val real: Double, val image: Double) extends Ordered[Complex] {
                        def magnitude = Math.sqrt(real*real + image*image)
                        def angle = Math.atan2(image, real)
                        def + (that: Complex) = new Complex(this.real + that.real, this.image + that.image)
                        def compare(that: Complex): Int = this.magnitude compare that.magnitude
                        override def toString = real+" + i*"+image+" | "+magnitude+"*e^(i*"+angle+"))"
                }

                val first = new Complex(1, 5)
                val second = new Complex(2, 4)
                val sum = first + second
                println(first)
                println(second)
                println(sum)
                if (first > second)
                        println("First greater")
                if (first < second)
                        println("Second greater")
                if (first == second )
                        println("They're equal")
        }

        def example2(unit: Unit):Unit = {
                class Complex(r: Double, i: Double) {
                        def >(that: Complex): Boolean = {
                                if (this < that) false else true
                        }
                        def <(that: Complex): Boolean = {
                                if((this.magnitude compare that.magnitude) == 0) true else false
                        }

                        def real = r
                        def image = i
                        def magnitude = Math.sqrt(r*r + i*i)
                        def angle = Math.atan2(i, r)
                        //def compare(that: Complex): Int = this.magnitude compare that.magnitude
                        def + (that: Complex) = new Complex(this.real + that.real, this.image + that.image)

                        override def toString = real+" + i*"+image+" | "+magnitude+"*exp(i*"+angle+"))"
                }

                val first = new Complex(1, 5)
                val second = new Complex(2, 4)
                val sum = first + second
                println(first)
                println(second)
                println(sum)
                if (first > second)
                        println("First greater")
                if (first < second)
                        println("Second greater")
                if (first == second )
                        println("They're equal")

        }

        def example1(unit: Unit):Unit = {
                def id(x: Int): Int = x

                def square(x: Int): Int = x * x

                def sum(f: Int => Int, a:Int, b: Int): Int = {if (a > b) 0 else f(a) + sum(f, a+1, b)}

                println(sum(id, 1, 5))
                println(sum(square, 1, 5))
        }

}

