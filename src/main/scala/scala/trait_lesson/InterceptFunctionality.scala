package scala.trait_lesson
import java.util

object InterceptFunctionality {

  def main(args: Array[String]): Unit = {

    val firstLogThenIgnoreCase=new util.HashSet[String]
    with CaseIgnore
    with Logging

    val firstIngoreCaseThenLog=new util.HashSet[String]
    with Logging
    with CaseIgnore

    firstLogThenIgnoreCase.add("HI")
    firstIngoreCaseThenLog.add("HI")

    println(firstIngoreCaseThenLog.contains("Hi") && firstLogThenIgnoreCase.contains("hi"))

  }
}

trait CaseIgnore extends java.util.Set[String]{
  abstract override def add(elm:String)=super.add(elm.toLowerCase)

  abstract override def contains(elm: Any): Boolean = super.contains(elm.toString.toLowerCase)

  abstract override def remove(elm: Any): Boolean = super.remove(elm.toString.toLowerCase)
}

trait Logging extends java.util.Set[String]{
  abstract override def add(elm:String)={
    println(s"add: $elm")
    super.add(elm)
  }

  abstract override def contains(elm: Any): Boolean = {
    println(s"contains: $elm")
    super.contains(elm)}

  abstract override def remove(elm: Any): Boolean ={
    println(s"remove: $elm")
    super.remove(elm)
  }
}
