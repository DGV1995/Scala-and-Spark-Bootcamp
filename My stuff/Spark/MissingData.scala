import org.apache.spark._

val spark = SparkSession.builder().getOrCreate()

// Dataset with some null data
val df = spark.read.option("header", "true").option("inferSchema", "true").csv("../Spark DataFrames/ContainsNull.csv")

df.printSchema()

// Drop null values
df.na.drop().show() // Drop every row with some null value
df.na.drop(2).show() // Drop any rows that have less than 2 NON-null values (< Int)

// Fill null values
df.na.fill(100).show() // Fill every null value in a NUMERICAL column with value 100
df.na.fill("Unknown").show() // Fill every null value in a CATEGORICAL column with value 'Unknown'

df.na.fill("New Name", Array("Name")).show() // Fill every null value in the specified columns
