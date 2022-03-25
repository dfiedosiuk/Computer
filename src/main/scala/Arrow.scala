import Computer.pcScreen

case class Arrow(name: String, var x: Int, var y: Int, var sign: String, var angle: Int) {

  def update(): Unit = {
    pcScreen.board(y)(x) = " " + sign + " "
  }

  def defineAngle(sign: String): Int = {
    sign match {
      case "<" => -90
      case "^" => 0
      case ">" => 90
      case "v" => 180
    }
  }

  def rotate(rot: Int): String = {
    angle + rot match {
      case 0 | 360 | -360 => "^"
      case 90 | -270 | 450 => ">"
      case 180 | -180 => "v"
      case -90 | 270 | -450 => "<"
    }
  }

  def moveArrow(forward: Int): Unit = {
    pcScreen.board(y)(x) = " _ "
    val possibleX = List.range(0, pcScreen.columns)
    val possibleY = List.range(0, pcScreen.rows)
    angle match {
      case 0 =>
        val move = y - forward
        if (possibleY.contains(move)) y = move
        else {
          println("Move out of range not executed!")
        }
      case 90 =>
        val move = x + forward
        if (possibleX.contains(move)) x = move
        else {
          println("Move out of range not executed!")
        }
      case 180 =>
        val move = y + forward
        if (possibleY.contains(move)) y = move
        else {
          println("Move out of range not executed!")
        }
      case -90 =>
        val move = x - forward
        if (possibleX.contains(move)) x = move
        else {
          println("Move out of range not executed!")
        }
    }
  }
}
