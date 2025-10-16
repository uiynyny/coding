"""
UTM: CSC108, Fall 2025

Practical Lab 6

Instructors: Michael Liut, Mai Ha Vu, Joshua Jung, Mohammad Mahmoud

This code is provided solely for the personal and private use of
students taking the CSC108 course at the University of Toronto.
Copying for purposes other than this use is expressly prohibited.
All forms of distribution of this code, whether as given or with
any changes, are expressly prohibited.

All of the files in this directory and all subdirectories are:
Copyright (c) 2025 Michael Liut, Haocheng Hu

LAB RESTRICTIONS, PLEASE READ:
Do not add any imports, the ones that you need will be given to you.
You may not use any dictionaries or dictionary methods, or recursion.
Do not use try-except statements, you should be able to anticipate
or prevent any errors from happening at all!
Within your loops, you MUST NOT use any break or continue statements.
"""

from typing import Any, List


def loopy_madness_with_while_loops(string1: str, string2: str) -> str:
    """
    The exact same function as loopy_madness from Lab 5, but we ask that you
    change any for loops that you used to while loops. Refer back to Lab 5 for
    the specifications of this function.

    Keep in mind that since we will run the same tests, the same restrictions
    from Lab 5 will apply to this function as well.

    You are NOT allowed to use any for loops for this function.
    """
    i,j = 0,0
    dir_i, dir_j = 1,1
    result = ""
    acc = 0
    while acc < max(len(string1),len(string2)):
        acc += 1
        if(i >= len(string1)-1):
            dir_i = -1
            i = len(string1)-1
        elif(i <= 0):
            dir_i = 1
            i = 0
        if(j >= len(string2) - 1):
            dir_j = -1
            j = len(string2) - 1
        elif(j <= 0):
            dir_j = 1
            j = 0
        result += string1[i] + string2[j]
        i += dir_i
        j += dir_j
    return result

print(loopy_madness_with_while_loops("ab", "12345")=="a1b2a3b4a5") #a1b2a3b4a5
print(loopy_madness_with_while_loops("1","a")=="1a") #1a
print(loopy_madness_with_while_loops("1","abcde")=="1a1b1c1d1e") #1a1b1c1d1e
print(loopy_madness_with_while_loops("abcde","2")=="a2b2c2d2e2") #a2b2c2d2e2


def longest_chain(lst: List[int]) -> int:
    """
    Given a list of integers, return the length of the longest chain of 1's
    that start from the beginning.

    You MUST use a while loop for this, and are not allowed to use a for loop.

    Hint: A good way to start is to define a stopping condition, and have a
    variable that keeps track of how many 1's you've seen thus far, if any.

    Precondition: <lst> will only contain the integers 1 and 0.

    >>> longest_chain([1, 1, 0])
    2
    >>> longest_chain([0, 1, 1])
    0
    >>> longest_chain([1, 0, 1, 1])
    1
    """
    acc = 0
    count = 0 
    while acc < len(lst) and lst[acc] == 1:
        acc += 1
        count += 1
    return count

print(longest_chain([1, 1, 1])) #3
print(longest_chain([0, 1, 1])) #0
print(longest_chain([1, 1, 0])) #2
print(longest_chain([1, 0, 1, 1])) #1
print(longest_chain([0])) #0
print(longest_chain([1])) #1
print(longest_chain([])) #0

def count_types(lst: List[Any]) -> List[int]:
    """
    Given a list <lst> of random types, return the number of occurrences of
    each type, in the form of a list, in the order that they were first seen.

    For example, if the input ['str1', 1, 'str2'], the output would be [2, 1],
    as a string type appears first, and occurs twice in the list. An integer
    type appears next, and only occurs once in the list.

    Another example could be [True, 'str1', 1, False, 'str2', True], where the
    output would be [3, 2, 1], as a boolean type appears first, and occurs
    three times in the list. A string appears next, and occurs twice in the
    list. Finally, an integer appears next, and occurs once in the list.

    Do not modify the input list.
    """
    '''
    [True,'s1',1,False,'s2',True]
     |
               |
    acc=0
    result = [3,2,1]
    seen = [Bool,Str,Int]
    changed= False
    '''
    
    result = []
    seen = [] # all type have seen so far
    acc = 0
    index = 0
    while index < len(lst):
        if type(lst[index]) not in seen:
            seen.append( type(lst[index]))
            acc += 1
            i = index + 1
            while i < len(lst):
                if type(lst[i]) == type(lst[index]):
                    acc += 1
                i += 1
            result.append(acc)
            acc = 0
        index += 1
    return result

print(count_types(['str1', 1, 'str2'])) #[2,1]
print(count_types([True, 'str1', 1, False, 'str2', True])) #[3,2,1]
print(count_types([])) #[]
print(count_types([None]))#[1]
print(count_types([1.1])) #[1]

def second_largest(lst: List[int]) -> int:
    """
    Given a list <lst> of integers, return the second largest item in the list
    without modifying <lst>. You cannot use any of python's builtin sorting
    functions. Do not attempt to sort the list yourself either.

    As a sanity check, you can ensure that your function returns what
    "return sorted(lst)[-2]" would. (DO NOT COPY THIS)

    For example, an input [1, 2, 3] should return an output of 2, since 2 is
    the second largest integer in the list.

    Note that when we say second largest, we do not mean second largest
    distinct element. That means that [1, 2, 4, 4] should return 4, not 2.

    Precondition: the input list has at least 2 elements.

    Something extra to think about (not graded): is it possible to write this
    function with an extra argument <n> and return the nth largest number in
    the list? Can you do this without sorting the list?
    """
    i = 0
    largest_index = 0
    largest = min(lst)
    # find the largest number and its index
    while i < len(lst):
        if (lst[i] > largest):
            largest = lst[i]
            largest_index = i
        i += 1
    j = 0
    second_largest = min(lst)
    # find the second largest number by avoiding the largest number index
    while j < len(lst):
        if (j != largest_index) and lst[j] >= second_largest:
            second_largest = lst[j]
        j += 1
    return second_largest
    '''
    [-2 -1]
     0 1
       ^
    '''

print(second_largest([1, 2, 3])) #2
print(second_largest([1, 2, 4, 4])) #4
print(second_largest([-2,-1])) #-2
print(second_largest([1,1])) #1