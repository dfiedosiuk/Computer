import Computer.pcScreen

import scala.io.Source
import scala.io.StdIn.readLine

case class ReadFile(filename: String) {
  val commands: Seq[String] = Source.fromFile(filename).getLines.toList
  var arrow1: Arrow = Arrow("ID1", 0, 0, "^", 0)

  def readCommands(): Unit = {
    commands.foreach(executeCommand)
  }

  def executeCommand(line: String): Unit = {
    println(line)
    val words = line.split("\\s+").toList
    words.head match {
      case "CREATE" =>
        arrow1 = Arrow("ID1", words(1).toInt, words(2).toInt, words(3), arrow1.defineAngle(words(3)))
        println("PC created arrow " + arrow1.name)
        arrow1.update()
      case "ROTATE" =>
        arrow1.sign = arrow1.rotate(words(2).toInt)
        arrow1.angle = arrow1.defineAngle(arrow1.sign)
        arrow1.update()
      case "MOVE" =>
        arrow1.moveArrow(words(2).toInt)
        arrow1.update()
      case _ => println("Not proper command!")
    }

    pcScreen.printBoard()
    val nextMove = readLine("Click enter to continue... ")
    println()
  }

}
