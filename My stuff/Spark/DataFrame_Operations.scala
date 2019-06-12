import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema", "true").csv("../Spark DataFrames/CitiGroup2006_2008")

//////////////////
//////////////////
import spark.implicits._

// Show the rows where 'Close' is greater than 480 with Scala notation
df.filter($"Close" > 480).show()

// The same, with SQL notation
df.filter("Close > 480").show(5)

df.filter($"Close" > 480 && $"High" > 490).show(5)
val new_df = df.filter("Close > 480 and High > 490").collect() // Save the data as an Array (each row is
                                                               // an element of the Array)

df.filter("High = 484.40").show()

// Pearson correlation between columns
df.select(corr("High", "Low")).show()

// Operations and Useful Functions
// http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$
