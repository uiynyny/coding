import sys
import math
from pyspark import SparkContext


def count(input_list):
    output = []
    for word in input_list:
        output.append((word, 1))
    return output


def prefix(pair, t):
    date, tokens = pair
    l = len(tokens)
    prelen = l - math.ceil(l * t) + 1
    return [date[:4], tokens[:prelen], tokens]


def sim(lst1, lst2):
    set1 = set(lst1)
    inter = set1.intersection(lst2)
    union = set1.union(lst2)
    return len(inter) / len(union)


def getsim(x, t):
    res = []
    for i in range(0, len(x[1])-1):
        for j in range(i, len(x[1])):
            if x[1][i][0] < x[1][j][0] and x[1][i][1] != x[1][j][1]:
                jsim = sim(x[1][i][2], x[1][j][2])
                if jsim >= t:
                    res.append(((x[1][i][0], x[1][j][0]), jsim))
    return res


if __name__ == "__main__":
    if len(sys.argv) != 4:
        print("Usage: comp9313p3.py <input file> <output file> <tau>")
        exit(-1)
    sc = SparkContext("local", "Project3")
    rdd = sc.textFile(sys.argv[1])
    rdd = rdd.map(lambda x: [x.split(',')[0], x.split(',')[1].split()])
    rdd.cache()
    new_rdd = rdd.map(lambda x: (count(x[1])))
    new_rdd = new_rdd.flatMap(lambda x: x)
    new_rdd = new_rdd.reduceByKey(lambda x, y: x + y).collectAsMap()
    word_order = sc.broadcast(new_rdd)
    rdd = rdd.map(lambda x: (x[0], sorted(
        x[1], key=lambda y: (word_order.value[y], y[0]))))

    t = float(sys.argv[3])

    prefix_rdd = rdd.map(lambda x: prefix(x, t))
    indexed_rdd = prefix_rdd.zipWithIndex()
    prefix_rdd = indexed_rdd.map(lambda x: (x[0][1], (x[1], x[0][0], x[0][2])))

    new_prefix_rdd = prefix_rdd.flatMap(
        lambda x: [(word, x[1]) for word in x[0]])

    final_rdd = new_prefix_rdd.groupByKey().mapValues(lambda x: list(x))
    final_rdd = final_rdd.filter(lambda x: len(x[1]) > 1)

    final_rdd = final_rdd.map(lambda x: getsim(x, t))
    final_rdd = final_rdd.flatMap(lambda x: x,).sortBy(lambda x: x[0][0]).distinct() 
    final_rdd.coalesce(1).saveAsTextFile(sys.argv[2])
