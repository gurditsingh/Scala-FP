package scala.Curring_lesson.implicit_func

object JsonBeauty {

  implicit def toJson[A](list:List[A]):String={

    "list = [ "+list.zipWithIndex.map(l =>  l._2.toString + " => " + l._1.toString).mkString(",")+" ]"
  }

}
