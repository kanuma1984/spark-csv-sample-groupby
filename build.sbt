name := "spark-csv-sample-groupby"

version := "0.0.1"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.4.0",
  "org.apache.spark" %% "spark-sql" % "1.4.0",
  "com.databricks" %% "spark-csv" % "1.0.3",
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3"
)
