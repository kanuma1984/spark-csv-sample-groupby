import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SQLContext, Row}
import scalax.file.Path

object Index {
  def main(args: Array[String]) {
    val conf: SparkConf = new SparkConf().setAppName("spark-csv-sample-groupby").setMaster("local[2]")
    val sc: SparkContext = new SparkContext(conf)
    val sqlContext: SQLContext = new SQLContext(sc)

    try {
      val df = sqlContext.read.format("com.databricks.spark.csv")
              .option("header", "true")
              .load("data/user_action.csv")

      df.groupBy("user_id").count().foreach(userId => println(userId))

    } catch {
      case e: Exception => println("arg " + e)
    } finally {
      sc.stop();
    }
  }
}
