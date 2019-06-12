// Most Important Link:
// http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.Dataset

import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

// the option inferSchema allows us to get the real type of the values (date, double, etc)
val df = spark.read.option("header", "true").option("inferSchema", "true").csv("../Spark DataFrames/CitiGroup2006_2008")

// show 5 first elements --> Also df.head() is valid, but it shows it uglier
df.show(5)

// returns an Array with the name of all the columns
df.columns

// Like a pandas dataframe describe() function
df.describe().show()

// Shows the column 'Volume' of the dataframe
df.select("Volume").show()
// Show several columns
df.select($"Volume", $"Date", $"Close").show(5)

// Create new columns
val df2 = df.withColumn("HighPlusLow", df("High") + df("Low"))

// Show schema
df2.printSchema()

// Change the name of a column
df2.select(df2("HighPlusLow").as("HPL")).show(5)
