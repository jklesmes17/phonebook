name := """phonebook"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  cache,
  specs2 % Test,
  "com.typesafe.slick" %% "slick" % "3.0.2",
  "com.typesafe.play" %% "play-slick" % "1.0.1",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.0.1",
  "org.postgresql" % "postgresql" % "9.4-1202-jdbc42",
  "joda-time" % "joda-time" % "2.8.2",
  "org.joda" % "joda-convert" % "1.7",
  "com.github.tototoshi" %% "slick-joda-mapper" % "2.0.0",
  "com.ejisan" %% "play-forms" % "2.0.1",
  "com.ejisan" %% "play-pagemeta" % "1.2.1"
)

libraryDependencies ++= Seq(
  "org.webjars" % "webjars-play_2.11" % "2.4.0-1",
  "org.webjars" % "foundation" % "5.5.2",
  "org.webjars" % "jquery" % "2.1.4",
  "org.webjars" % "backbonejs" % "1.2.1",
  "org.webjars" % "pace" % "1.0.2",
  "org.webjars" % "font-awesome" % "4.4.0",
  "org.webjars" % "handsontable" % "0.17.0"
)

sassOptions in Assets ++= Seq("--compass", "-r", "compass")
sassOptions in Assets ++= Seq("--cache-location", "target/web/sass/.sass-cache")

dependencyOverrides += "org.webjars" % "jquery" % "2.1.4"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

resolvers += "Ejisan Github" at "https://ejisan.github.io/repo/"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

TwirlKeys.templateImports ++= Seq(
  "ejisan.play.libs.PageMeta",
  "libs.PjaxHeader"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-optimise",
  "-explaintypes",
  "-encoding", "UTF-8",
  "-Xlint",
  "-language:reflectiveCalls",
  "-language:implicitConversions",
  "-language:postfixOps"
)
