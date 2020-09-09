package scala.state


case class GameState(numOfFlips:Int,numOfCorrectGuesses:Int)


class FlipCoinGame {

  def printPrompt(): Unit ={
    println("(h) for Head, (t) for Tail, (q) for Quit")
  }

  def printResult(gameState: GameState,result:String): Unit ={
    println(s"Flip was $result. Num of Filps: ${gameState.numOfFlips}, Num of Correct Guess: ${gameState.numOfCorrectGuesses} \n")
  }

  def wrongPrompt(input :String): Unit ={
    println(s"wrong input: $input !!! Try again \n")
  }

  def toss(): String =  {
   val guess= new java.util.Random().nextInt(2)
    guess match {
      case 0 => "H"
      case 1 => "T"
    }
  }

  def flipName(guess:String): String = guess match {
    case "H" => "Head"
    case "T" => "Tail"
  }

  def gameOverPrompt(gameState: GameState): Unit ={
    println("===>Game Over<===")
    println(s"Game Stats: ${gameState.numOfFlips} out of ${gameState.numOfCorrectGuesses} correct.")
  }


  def gameStart(gameState: GameState): Unit = {

    printPrompt()
    val input = scala.io.StdIn.readLine().trim.toUpperCase

    input match {
      case "Q" => gameOverPrompt(gameState)
      case "H" | "T" => {
        val guess = toss()
        if(guess.endsWith(input)) {
          val updatedGameState=GameState(gameState.numOfFlips + 1, gameState.numOfCorrectGuesses + 1)
          printResult(updatedGameState, flipName(guess))
          gameStart(updatedGameState)
        }
          else{
          val updatedGameState=GameState(gameState.numOfFlips + 1, gameState.numOfCorrectGuesses)
          printResult(updatedGameState, flipName(guess))
          gameStart(updatedGameState)
        }
      }
      case _ =>{
        wrongPrompt(input)
        gameStart(gameState)
      }
    }

  }



}

object Test{
  def main(args: Array[String]): Unit = {

    new FlipCoinGame().gameStart(GameState(0,0))

  }
}
