name := "untitled"
 
version := "1.0" 
      
lazy val `untitled` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( jdbc , cache , ws , specs2 % Test )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

// an example of how to change the default port from 9000 to some other
//PlayKeys.devSettings := Seq("play.server.http.port" -> "8080")