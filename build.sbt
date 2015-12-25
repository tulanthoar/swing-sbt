// factor out common settings into a sequence
lazy val commonSettings = Seq(
  organization := "com.github.tulanthoar",
  // package version
  version := "0.1.0",
  // set the Scala version used for the project
  scalaVersion := "2.11.7",
  // Cache all managed dependencies to <build-root>/lib_managed/
  retrieveManaged := true,
  // append several options to the list of options passed to the Java compiler
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  // append -deprecation and -featur to the options passed to the Scala compiler
  scalacOptions ++= Seq("-deprecation", "-feature"),
  // set the prompt (for the current project) to include the username and +projectname
  shellPrompt := { state => (System getProperty "user.name") + " " + (Project extract state).currentRef.project + "> " },
  // change the format of how sbt prints time
  timingFormat := {
    import java.text.{DateFormat => DF}
    DF.getDateTimeInstance(DF.SHORT, DF.SHORT)
  }
)

lazy val swingSbt = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    // set the name of the project
    name := "SwingSbt"
  )
