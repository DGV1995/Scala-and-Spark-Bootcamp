import org.apache.spark._

var spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema", "true").csv("../Spark DataFrames/CitiGroup2006_2008")

//df.select(year(df("Date"))).show(5)

val df2 = df.withColumn("Year", year(df("Date")))
//df2.show(5)

// Average of the Close for each year
val dfavgs = df2.groupBy("Year").mean()
dfavgs.select($"Year", $"avg(Close)").show()
// It can be in one line ==> df2.groupBy("Year").mean().select($"Year", $"avg(Close)").show()

// Max Close value in each year
df2.groupBy("Year").max().select($"Year", $"max(Close)").show()
