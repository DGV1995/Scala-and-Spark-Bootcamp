import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema", "true").csv("../Spark DataFrames/CitiGroup2006_2008")

df.show(5)
