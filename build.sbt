// factor out common settings into a sequence
lazy val commonSettings = Seq(
  organization := "org.myproject",
  version := "0.1.0",
// set the Scala version used for the project
  scalaVersion := "2.11.7"
)

lazy val app = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    // set the name of the project
    name := "app",
    //libraryDependencies += "com.codenvy" % "example-swing" % "1.0",
    // add a test dependency on ScalaCheck
    //libraryDependencies += scalacheck % Test,
    
    // append several options to the list of options passed to the Java compiler
    javacOptions ++= Seq("-source", "1.7", "-target", "1.7"),

    // append -deprecation to the options passed to the Scala compiler
    scalacOptions ++= Seq("-deprecation", "-feature"),

    // define the statements initially evaluated when entering 'console', 'consoleQuick', or 'consoleProject'
    initialCommands := """
      |import System.{currentTimeMillis => now}
      |def time[T](f: => T): T = {
      |  val start = now
      |  try { f } finally { println("Elapsed: " + (now - start)/1000.0 + " s") }
      |}""".stripMargin,

    // set the initial commands when entering 'console' or 'consoleQuick', but not 'consoleProject'
    //initialCommands in console := "import com.codenvy.example.scala._",
    
    // set the prompt (for the current project) to include the username
    shellPrompt := { state => System.getProperty("user.name") + "  " + Project.extract(state).currentRef.project + "> " },

    // change the format used for printing task completion time
    timingFormat := {
        import java.text.DateFormat
        DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT)
    },
    
    // set the location of the JDK to use for compiling Java code.
    // if 'fork' is true, this is used for 'run' as well
    //javaHome := Some(file("/usr/lib/jvm/sun-jdk-1.6")),

    // Use Scala from a directory on the filesystem instead of retrieving from a repository
    //scalaHome := Some(file("/home/user/scala/trunk/")),

    // don't aggregate clean (See FullConfiguration for aggregation details)
    aggregate in clean := false,

    // only show warnings and errors on the screen for compilations.
    //  this applies to both test:compile and compile and is Info by default
    logLevel in compile := Level.Warn,

    // only show warnings and errors on the screen for all tasks (the default is Info)
    //  individual tasks can then be more verbose using the previous setting
    logLevel := Level.Warn,

    // only store messages at info and above (the default is Debug)
    //   this is the logging level for replaying logging with 'last'
    persistLogLevel := Level.Debug,
    
    // only show 10 lines of stack traces
    traceLevel := 10,

    // only show stack traces up to the first sbt stack frame
    traceLevel := 0,
    
    // Copy all managed dependencies to <build-root>/lib_managed/
    //   This is essentially a project-local cache and is different
    //   from the lib_managed/ in sbt 0.7.x.  There is only one
    //   lib_managed/ in the build root (not per-project).
    retrieveManaged := true
)