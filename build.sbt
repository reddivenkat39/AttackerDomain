name := """AttackerDomain"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.mongodb.morphia" % "morphia" % "0.107",
  "org.mindrot" % "jbcrypt" % "0.3m"
)

EclipseKeys.projectFlavor := EclipseProjectFlavor.Java

EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses,

EclipseCreateSrc.ManagedResources)

EclipseKeys.preTasks := Seq(compile in Compile)