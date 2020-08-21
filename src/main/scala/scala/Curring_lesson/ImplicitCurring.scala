package scala.Curring_lesson

object ImplicitCurring {


  def beautify[A](list:List[A])(implicit f : List[A] => String):String={
    f(list)
  }

  def main(args: Array[String]): Unit = {

    import implicit_func.JsonBeauty._

    println(beautify[Int](List(1,2,3,4)))

    println(beautify[String](List("A","B","C","D")))
  }

}
