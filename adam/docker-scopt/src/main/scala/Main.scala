import scopt.OParser

object Main extends App {
  case class Config(numbers: Int = 999, words: String = "")

  val myBuilder = OParser.builder[Config]

  val myParser = {
    import myBuilder._
    OParser.sequence(
      programName("adam"),
      head("scopt", "1.0.0-alpha"),
      help("help").text("prints this usage text"),
      opt[Int]('n', "numbers")
        .action((value, cfg) => cfg.copy(numbers = value))
        .text("My name property"),
      opt[String]('w', "words")
        .action((value, cfg) => cfg.copy(words = value))
        .text("My name property")

    )
  }

  val config = OParser.parse(
    myParser,
    args,
    Config()).get

  println(s"Numbers: ${config.numbers} ------> Words: ${config.words}")
}