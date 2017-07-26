name := "untitled"
 
version := "1.0" 
      
lazy val `untitled` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq( jdbc , cache , ws , specs2 % Test )

libraryDependencies += "org.reactivemongo" %% "play2-reactivemongo" % "0.11.11"


unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

