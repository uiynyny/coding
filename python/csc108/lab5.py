"""
UTM: CSC108, Fall 2025

Practical Lab 5

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
You must not use any lists, list methods, or while loops.
Within your loops, you MUST NOT use any break or continue statements.
Furthermore, you must not use try-except statements, as you should be able to
anticipate or prevent any errors from ever occurring!
"""


def sum_string(string: str) -> int:
    """
    Given a string <string>, return the sum of this string, as computed by the
    formula given below:

    To compute the sum of a string as defined by this function, we add every
    odd positioned digit, and subtract every even positioned digit. For example,
    if we had an input of "54321", we would add 5, subtract 4, add 3, subtract
    2, and add 1, bringing us to a total of 3. In other words, you would add the
    first digit, subtract the second digit, and keep alternating until you reach
    the end of the string. If the string is empty, then the sum is 0.

    Note: since we give the input as a string, you will have to do some type
    conversion in order to solve this problem.

    Precondition: <string> will only contain the characters 0-9.
    """
    # 54321 -> 5 4 3 2 1
    #          0 1 2 3 4
    sum = 0
    for i in range(len(string)):
        if(i%2 == 0):
            sum += int(string[i])
        else:
            sum -= int(string[i])
    return sum


def substring_with_largest_sum(string: str) -> str:
    """
    Given a string <string>, return the substring with the largest sum (as
    calculated by sum_string()) that exists within <string>. If there are
    multiple substrings with equally large sums, return the first one that
    occurs. The substring could just be the whole string itself, or it could
    be empty.

    To calculate the sum of the substring, you must use the function
    sum_string() which you have implemented above as a helper.

    For example, given the string "321", there are 7 possible substrings:
    "", "3", "2", "1", "32", "21", "321". For each one of them, their sum can
    be calculated as per the sum_string() function which you have already
    implemented. By using your understanding of loops, implement this function
    to return the substring with the largest sum by checking all of the
    substrings of the input string. So, "32" evaluates to 1, "21" also
    evaluates to 1, "321" evaluates to 2, resulting in "3" being the largest
    possible substring as it evaluates to 3.
    """
    # 54321 5 54 543 5432 54321 4 43 432 4321 3 32 321 2 21 1 ""
    max_sum = 0
    result = ""
    for i in range(len(string)): #1 -- 5
        for j in range(i+1, len(string)+1): #5 -- end
            substr = string[i:j]# 4:5
            current_sum = sum_string(substr)
            if current_sum > max_sum:
                max_sum = current_sum
                result = substr
    return result


def loopy_madness(string1: str, string2: str) -> str:
    """
    Given two strings <string1> and <string2>, return a new string that
    contains letters from these two strings "interwoven" together, starting with
    the first character of <string1>. If the two strings are not of equal
    length, then start looping "backwards-and-forwards" in the shorter string
    until you come to the end of the longer string.

    "interwoven" (or "interweaving") means constructing a new string by taking
    the first letter from the first string, adding the first letter of the
    second string, adding the second letter of the first string,
    adding the second letter of the second string, and so on.

    "backwards-and-forwards" is a custom looping term. First the loop starts
    at position 1 (index 0) and goes until position n (i.e., the end). Once the
    loop reaches position n, it goes backwards, starting at position n - 1 and
    goes to position 1 (index 0). This repeats until the two strings are
    interwoven. For example, the backwards-and-forwards operations of "abc"
    would be "abcbabcba..."

    Examples:
        If you are given "abc" and "123", then the output string is "a1b2c3".
        This is after taking "a" from the first string, adding "1" from the
        second string, adding "b" from the first string, and so on.

        Things get more interesting when you are given two strings that differ
        in length. For example, if you are given "abcde" and "12", then the
        output would be "a1b2c1d2e1". Notice how the shorter string loops
        around when it runs out of characters, and continues looping until the
        longer string is exhausted.

        Another example of the "backwards-and-forwards" implementation given
        two strings of differing length: "abcdfe" and "123", then the output
        would be "a1b2c3d2f1e2".

        Note that the first string could be shorter too, for example, given
        "ab" and "123", the output would be "a1b2a3".


    Precondition: both input strings will NOT be empty.

    Hint: a good sanity check is to ensure that your output string is exactly
    twice the length of the longer input string :)  
    """
    # ab  12345
    #  i     j
    # a1b2a3b4a5
    i,j = 0,0
    dir_i, dir_j = 1,1
    result = ""
    for _ in range(max(len(string1),len(string2))):
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

print(loopy_madness("ab", "12345")) #a1b2a3b4a5
print(loopy_madness("1","a")) #1a
print(loopy_madness("1","abcde")) #1a1b1c1d1e
print(loopy_madness("abcde","2")) #a2b2c2d2e2

#a1b2a3b4a5
#1a
#1a1b1c1d1e
#a1b2a3b4a5
#1a
#1a1b1c1d1e
#a2b2c2d2e2