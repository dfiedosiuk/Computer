object Computer extends App {
  val File = ReadFile("instructions.txt")
  val pcScreen = Board(6,7)
  File.readCommands()
}
