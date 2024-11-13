
myvar="example"

b=myvar

myvar="hello"

a=[0,1,2,3,4]



b=a.copy()
#b<-[0,1,2,3,4]

b[0+1]=9

a,b => [0]
a[0+2]


print(b)#=>"example"

myvar=> "example"

type(myvar)=> (str)

"example".__add__('stt') =="example"+"stt"
"m" in "example" == "example".__contains__("m")
"example".__gt__("example1") == "example" > "example1"
"example".__ge__ >=
"exam".__le__ <=
"exam".__lt__ <

len("banana") == "banana".__len__()

1 < 2 true

myvar.upper()

"banana" => "BANANA"
"apple"
"car"
myvar="apple"


myvar.upper()...


(define (myfunc mystr)
    (helper (string->list mystr))
)

# len(mystr)=n
# (first mystr) == mystr[0]
#(rest mystr) == mystr[1:]
def findC(mystr):
    if mystr=="": #[(empty? mystr)...]
        # base case
        return False
    elif mystr[0]=='c': 
        return True
    else:
        return findC(mystr[1:])

#(list ....)

[1,2,3,4,5,6]
["a","abc","example","hello"]
[True,False,1,"a"]
a=[1,2,3,4,5,6,7,8]

a.append(6)
a.extend([6,7,8]) #0 到 n 重复做 a.append(...)
a.index(6)=>5
a[5]=>6

a.insert(0,10)
a.remove()
(list 1 2 (list 3 4))
[1, 2, [3, 4]]
sum([1,2])

