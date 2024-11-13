from pyspark.sql import SparkSession
from pyspark.sql.functions import udf, concat, col, lit
from pyspark.sql.types import DoubleType
import sys

if __name__ == "__main__":
    sc = SparkSession.builder.appName("SparkApp").getOrCreate()
    rdd = sc.sparkContext.textFile(sys.argv[1]).zipWithIndex().map(
        lambda x: [x[1], x[0].split(',')[0][:4], x[0].split(',')[1].split()])
    df = rdd.toDF()

    df = df.select(col('_1').alias('id'), col(
        '_2').alias('year'), col('_3').alias('tokens'))

    def sim(lst1, lst2):
        set1 = set(lst1)
        inter = set1.intersection(lst2)
        union = set1.union(lst2)
        return len(inter) / len(union)

    j_sim = udf(sim, DoubleType())

    l = df.alias('l').withColumnRenamed('id', 'lid')
    r = df.alias('r').withColumnRenamed('id', 'rid')

    filter_expr = 'j_sim >= {0}'.format(sys.argv[3])

    df = l.join(r, [l.year != r.year, l.lid < r.rid]).withColumn('j_sim', j_sim('l.tokens', 'r.tokens')).filter(
        filter_expr).select(concat(lit('('), col('lid'), lit(','), col('rid'), lit(')')).alias('pair'), 'j_sim')
    df = df.select(concat(col('pair'), lit('\t'), col('j_sim')))
    df.coalesce(1).write.save(sys.argv[2],format='text')
