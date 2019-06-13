import org.apache.spark._
var spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema", "true").csv("../Spark DataFrames/Netflix_2011_2016.csv")

// What are the column names?
df.columns

// What does the schema look like?
df.printSchema()

// Print out the first 5 rows
df.show(5)

// Use describe() to learn about the DataFrame
df.describe().show()

// Create a new dataframe with a column called HV Ratio, that is the ratio of the High Price versus volume of stocks
// traded for a day
var df2 = df.withColumn("HV Ratio", df("High")/df("Volume"))
df2.show(4)

// What day had the Peak High in Price?
var df3 = df.withColumn("Day", dayofmonth(df("Date")))
df3.groupBy("Day").max().select($"Day", $"max(High)").orderBy($"max(High)" desc).show(1)

// What is the mean of the Close column?
df.select(avg("Close")).show()

// What is the max and min of the Volume column?
df.select(max("Volume")).show()
df.select(min("Volume")).show()

// How many days was the Close lower than $ 600?
df.withColumn("Day", dayofmonth(df("Date"))).filter("Close < 600").count()

// What percentage of the time was the High greater than $500?
var total_high_count = df.filter("High > 500").count()*1.0
var df_length = df.count()
var percentage = (total_high_count/df_length) * 100
println(s"$percentage %")

// What is the Pearson correlation between High and Volume?
df.select(corr("High", "Volume")).show()

// What is the max High per year?
df.withColumn("Year", year(df("Date"))).groupBy("Year").max().select($"Year", $"max(High)").show()

// What is the average Close for each month?
df.withColumn("Month", month(df("Date"))).groupBy("Month").mean().select($"Month", $"avg(Close)").show()
