# scala-encase

An Scala library for changing between camelCase, snake_case, kebab-case, and more.
  
See also [encase.js](https://github.com/process-street/encase.js) for the JavaScript version. 

## Installation

In [SBT](http://http://www.scala-sbt.org/):

```
// Still need to set this up
```

## Notes

This method will provides a global Encase object. That means that once you include it, you can use it like this:

```scala
var str = "camelCase";
var convertedStr = Encase.toLowerSnake(str);
// = "camel_case"
```

Encase supports switching to 6 cases:

* `toLowerCamel` (e.g. `someVariableName`)
* `toUpperCamel` (e.g. `SomeVariableName`)
* `toLowerSnake` (e.g. `some_variable_name`)
* `toUpperSnake` (e.g. `SOME_VARIABLE_NAME`)
* `toLowerKebab` (e.g. `some-variable-name`)
* `toUpperKebab` (e.g. `SOME-VARIABLE-NAME`)

Encase automatically detects the "from" case, so you only have to tell it what you want to switch to. It also provides
a general `separate` function for splitting up strings:

```scala
val str = "camelCase";
val words = Encase.separate(str);
// = List("camel", "Case")
```

In addition to `separate`, Encase provides a `convert` function for making arbitrary conversions to any case:

The arguments are:

* `headTransform`: how the the first word should be transformed
* `tailTransform`: how the rest of the words should be transformed
* `sep`: how the words should be joined back together
* `str`: the string to operate on

Here's an example for converting any casing to "colon case" (which is used in products like Redis for key naming):

```scala
val str = "UpperCamel";
def lowerCase = (_: String).toLowerCase
val convertedStr = Encase.convert(lowerCase, lowerCase, ":", str);
// = "upper:camel"
```

## Author

[Cameron McKay](https://cdmckay.org/)

## License

This library is available under the [MIT](http://opensource.org/licenses/mit-license.php) license.
