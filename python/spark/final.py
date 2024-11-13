"""
userID, [loc1 loc2 loc3 loc4...]
...
====
userID1, location1
userID1, location2
....
===
loc1, [userID1 userID2 userID3 userID4...]
"""
def map(row):
   row.userID,
   row.locations
   userID, locations = row.split(",")
   for location in locations:
      emit(userID, location)

def reduce(KVpairs):
    result={}
    for KVpair in KVpairs:
        if KVpair.value not in result:
            result[KVpair.value] = []
        result[KVpair.value].add(KVpair.key)
    return result


"""
EmployeeID Name departmentID Salary
===
DepartmentID, [EmployeeID1 EmployeeID2 EmployeeID3...]// highest salary
"""
def init():
    result={}
    highestSalary=0
    
def map(id, name, dept, salary):
    emit(dept+" "+salary, name)

def reduce(key,value):
    dept, salary = key.split(" ")
    if salary > highestSalary:
        highestSalary = salary
        if dept not in result:
            result[dept]=[]
        
        result[dept].add(value)
    
    
conf: 
field.separator=" "
key.parititioner="-k1,1"
comparator="-k1,1 -k2,2nr"

def init():
    result={}

def map(word):
    emit(word, 1)

def reducer(key,value):
    if key not in result :
        if len(result)>k
            for word in result:
                result[word]-=1
                if result[word]==0:
                    del result[word]
        else:
            result[key]=0  
    result[key]+=value
    
    
sc = SparkContext(conf).getOrCreate()
text = sc.textFile(textfile)
lines = text.flatMap(lambda line: line.toLowerCase())
def helper(line):
    words = line.split(" ")
    for i in range(len(words)):
        for j in range(i+1,len(words)):
            (words[i], words[j])
            
"""
((w1,w2),1)

"""