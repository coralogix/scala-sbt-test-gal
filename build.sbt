ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

lazy val root = (project in file("."))
  .settings(
    name := "SbtExampleProject"
  )

libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.10.1"
// Ignored locally has jackson-module-scala bring a newer version of databind
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.8"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % Test
