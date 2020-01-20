val commonSettings = Seq(
  scalaVersion := "2.12.1"
)

lazy val scalactic = "org.scalactic" %% "scalactic" % "3.1.0"
lazy val scalatest = "org.scalatest" %% "scalatest" % "3.1.0"
lazy val scalacheck = "org.scalacheck" %% "scalacheck" % "1.14.1"

lazy val root = (project in file("."))
  .aggregate(exercises, answers)
  .settings(commonSettings)
  .settings(
name := "fpinscala"
)

lazy val exercises = (project in file("exercises"))
  .settings(commonSettings)
  .settings(
    name := "exercises",
    libraryDependencies += scalactic,
//    libraryDependencies += scalatest % Test,
    libraryDependencies += scalacheck % Test
  )

lazy val answers = (project in file("answers"))
  .settings(commonSettings)
  .settings(
    name := "answers"
  )
