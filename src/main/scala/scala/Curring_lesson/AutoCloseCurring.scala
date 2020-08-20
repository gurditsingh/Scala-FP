package scala.Curring_lesson

import java.io.FileReader


trait Closeable{
  def close():Unit
}

object AutoCloseCurring {

  def using1[A <: Closeable, B](param: A)(f: A => B): B = {
    try {
      f(param)
    }
    finally {
      param.close()
    }
  }

  def using2[A <: {def close() : Unit}, B](param: A)(f: A => B): B = {
    try {
      f(param)
    }
    finally {
      param.close()
    }
  }


  def main(args: Array[String]): Unit = {

    println("***Using Closeable trait as type bound***")
    using1[FileReader with Closeable,Unit](new FileReader("src\\main\\scala\\scala\\Curring_lesson\\AutoCloseCurring.scala") with Closeable){
      fr => println("File Encoding : "+ fr.getEncoding)
    }
    println("*"*20)

    println("-"*30)

    println("***Using method as type bound***")
    using2[FileReader,Unit](new FileReader("src\\main\\scala\\scala\\Curring_lesson\\AutoCloseCurring.scala")){
      fr => println("File Encoding : "+ fr.getEncoding)
    }
    println("*"*20)
  }

}
