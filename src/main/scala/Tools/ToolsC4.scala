package Tools

import scala.collection.immutable.{Map => M}

/**
  * Created by cubazis on 19.12.17.
  */
object ToolsC4 {
        implicit class ImmutableMapExtended(m: M[_,_]) {
                def printmap(l: String = "<< ", r: String = " >>"): Unit = {
                        print(l); m.printmap; println(r);
                }

                def printmap: Unit = {
                        if(m.size != 1) {
                                print(m.head._1+": "+m.head._2+", "); m.tail.printmap
                        } else {
                                print(m.head._1+": "+m.head._2)
                        }
                }
        }
}
