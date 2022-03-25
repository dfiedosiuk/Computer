case class Board(columns: Int, rows: Int){
  val board: Array[Array[String]] = Array.fill(rows, columns)(" _ ")

  def printBoard(): Unit = {
    board.foreach { row => row foreach print; println }
  }


}
