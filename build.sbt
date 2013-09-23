import AssemblyKeys._ // put this at the top of the file
import sbtassembly.Plugin._

name := "GeoScala"

organization := "com.misiunas"

version := "0.1"

scalaVersion := "2.10.2"

// Publish with command:
// publish-local


// --- Libraries ---

// TEST
libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"

// JUNIT
libraryDependencies += "junit" % "junit" % "4.10" % "test"

// BREEZE - https://github.com/scalanlp/breeze/
libraryDependencies  += "org.scalanlp" % "breeze-math_2.10" % "0.5-SNAPSHOT"

resolvers ++= Seq(
            // other resolvers here
            // if you want to use snapshot builds (currently 0.4-SNAPSHOT), use this.
            "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
            "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)