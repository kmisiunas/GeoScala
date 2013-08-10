import AssemblyKeys._ // put this at the top of the file
import sbtassembly.Plugin._

name := "GeoScala"

organization := "com.misiunas"

version := "0.1"

scalaVersion := "2.10.2"

// --- Libraries ---

// TEST
libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"

// JUNIT
libraryDependencies += "junit" % "junit" % "4.10" % "test"