name := "untitled"
 
version := "1.0" 
      
lazy val `untitled` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( jdbc , cache , ws , specs2 % Test )

libraryDependencies +=  "org.reactivemongo" %% "play2-reactivemongo" % "0.12.5-play25"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )
