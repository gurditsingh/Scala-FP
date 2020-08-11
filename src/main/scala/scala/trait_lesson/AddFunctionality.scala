package scala.trait_lesson

import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

object AddFunctionality {
  def main(args: Array[String]): Unit = {

    // First Lesson
    println("First Lesson :"+"-" * 50)
    val fileWithTime=new FileWithTimeStamp("scala/trait_lesson/AddFunctionality.scala")

    showName(fileWithTime)
    showTimeStamp(fileWithTime)

    // Second Lesson
    println("Second Lesson :"+"-" * 50)
    val fileObjWithTime=new File("scala/trait_lesson/AddFunctionality.scala") with TimeStamp

    showName(fileObjWithTime)
    showTimeStamp(fileObjWithTime)

    // Third Lesson
    println("Third Lesson :"+"-" * 50)
    val fileObject : File with TimeStamp=new File("scala/trait_lesson/AddFunctionality.scala") with TimeStamp

    showName(fileObject)
    showTimeStamp(fileObject)

    // Fourth Lesson
    println("Fourth Lesson :"+"-" * 50)
    type bothType = File with TimeStamp
    val bothType : bothType=new File("scala/trait_lesson/AddFunctionality.scala") with TimeStamp

    showName(bothType)
    showTimeStamp(bothType)
  }

  def showName(file:java.io.File): Unit ={
    println(file.getName)
  }
  def showTimeStamp(time:TimeStamp): Unit ={
    println(time.creationTime)
  }

}

trait TimeStamp{

  val creationTime:String={
    val format="HH:mm:ss"
    val sdf=new SimpleDateFormat(format)
    sdf.format(new Date())
  }
}

class FileWithTimeStamp(path:String) extends java.io.File(path) with TimeStamp
