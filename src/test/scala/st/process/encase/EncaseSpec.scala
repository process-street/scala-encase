package st.process.encase

class EncaseSpec extends org.specs2.mutable.Specification {

  "separate" should {

    "separate lowerCamel case" >> {
      val str = "lowerCamelCase"
      val words = Encase.separate(str)
      words should_== List("lower", "Camel", "Case")
    }

    "separate UpperCamel case" >> {
      val str = "UpperCamelCase"
      val words = Encase.separate(str)
      words should_== List("Upper", "Camel", "Case")
    }

    "separate lower_snake case" >> {
      val str = "lower_snake_case"
      val words = Encase.separate(str)
      words should_== List("lower", "snake", "case")
    }

    "separate UPPER_SNAKE case" >> {
      val str = "UPPER_SNAKE_CASE"
      val words = Encase.separate(str)
      words should_== List("UPPER", "SNAKE", "CASE")
    }

    "separate lower-kebab case" >> {
      val str = "lower-kebab-case"
      val words = Encase.separate(str)
      words should_== List("lower", "kebab", "case")
    }

    "separate UPPER-KEBAB case" >> {
      val str = "UPPER-KEBAB-CASE"
      val words = Encase.separate(str)
      words should_== List("UPPER", "KEBAB", "CASE")
    }

    "separate separate 1 word to itself" >> {
      val str = "word"
      val words = Encase.separate(str)
      words should_== List("word")
    }

  }

  "convert" should {

    "convert lower-kebab to lowerCamel case" >> {
      val str = "some-attribute"
      val convertedStr = Encase.toLowerCamel(str)
      convertedStr should_== "someAttribute"
    }

    "convert UPPER_SNAKE to UpperCamel case" >> {
      val str = "SOME_CONSTANT"
      val convertedStr = Encase.toUpperCamel(str)
      convertedStr should_== "SomeConstant"
    }

    "convert between lowerCamel and lower_snake case" >> {
      val str = "someAttribute"
      val convertedStr = Encase.toLowerSnake(str)
      convertedStr should_== "some_attribute"
    }

    "convert between UPPER-KEBAB and UPPER_SNAKE case" >> {
      val str = "SOME-CONSTANT"
      val convertedStr = Encase.toUpperSnake(str)
      convertedStr should_== "SOME_CONSTANT"
    }

    "convert between UpperCamel and lower-kebab" >> {
      val str = "SomeClass"
      val convertedStr = Encase.toLowerKebab(str)
      convertedStr should_== "some-class"
    }

    "convert between lower_snake and UPPER-KEBAB" >> {
      val str = "some_thing"
      val convertedStr = Encase.toUpperKebab(str)
      convertedStr should_== "SOME-THING"
    }

  }

}
