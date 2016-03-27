package st.process.encase

object Encase {

  def toLowerCamel(str: String): String = convert(lowerCase, titleCase, "", str)

  def toUpperCamel(str: String): String = convert(titleCase, titleCase, "", str)

  def toLowerSnake(str: String): String = convert(lowerCase, lowerCase, "_", str)

  def toUpperSnake(str: String): String = convert(upperCase, upperCase, "_", str)

  def toLowerKebab(str: String): String = convert(lowerCase, lowerCase, "-", str)

  def toUpperKebab(str: String): String = convert(upperCase, upperCase, "-", str)

  private def titleCase = (_: String).toLowerCase.capitalize

  private def lowerCase = (_: String).toLowerCase

  private def upperCase = (_: String).toUpperCase

  def convert(headTransform: String => String, tailTransform: String => String, sep: String, str: String): String =
    (separate(str) match {
      case head :: tail => headTransform(head) :: tail.map(tailTransform)
      case list => list
    }) mkString sep

  private val separatorPattern = List(
    "\\s+", "_", "-",
    "(?<=[A-Z])(?=[A-Z][a-z])",
    "(?<=[^A-Z_-])(?=[A-Z])",
    "(?<=[A-Za-z])(?=[^A-Za-z])"
  ).mkString("|").r

  def separate(str: String): List[String] = separatorPattern.split(str).toList

}
