// GROUP BY AND AGGREGATE FUNCTIONS

import org.apache.spark.sql._

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema", "true").csv("../Spark DataFrames/Sales.csv")

//df.groupBy("Company").max().show()

df.select(sum("Sales")).show()
df.select(countDistinct("Sales")).show()
df.select(sumDistinct("Sales")).show()
df.select(variance("Sales")).show()
df.select(stddev("Sales")).show()
df.select(collect_set("Sales")).show()

// Other Aggregate Functions
// http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$
