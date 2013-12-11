import AssemblyKeys._ // put this at the top of the file
import sbtassembly.Plugin._

name := "GeoScala"

organization := "com.misiunas"

version := "0.1.3"

scalaVersion := "2.10.3"

// Publish with command:
// publish-local


// --- Libraries ---

// TEST - http://www.scalatest.org/
libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

// BREEZE - https://github.com/scalanlp/breeze/
libraryDependencies  += "org.scalanlp" % "breeze_2.10" % "0.5.2"

resolvers ++= Seq(
            // other resolvers here
            // if you want to use snapshot builds (currently 0.5-SNAPSHOT), use this.
            "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
            "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)