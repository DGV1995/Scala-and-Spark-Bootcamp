import org.apache.spark._

var spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema", "true").csv("../Spark DataFrames/CitiGroup2006_2008")

df.printSchema()
