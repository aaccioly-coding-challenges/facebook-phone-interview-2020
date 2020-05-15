lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.facebook",
      scalaVersion := "2.13.1"
    )),
    name := "facebook-phone-interview-2020"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % Test
