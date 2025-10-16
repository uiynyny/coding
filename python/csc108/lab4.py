"""
UTM: CSC108, Fall 2025

Practical Lab 4

Instructors: Michael Liut, Mai Ha Vu, Joshua Jung, Mohammad Mahmoud

This code is provided solely for the personal and private use of
students taking the CSC108 course at the University of Toronto.
Copying for purposes other than this use is expressly prohibited.
All forms of distribution of this code, whether as given or with
any changes, are expressly prohibited.

All of the files in this directory and all subdirectories are:
Copyright (c) 2025 Michael Liut, Haocheng Hu

LAB RESTRICTIONS, PLEASE READ:
You are not allowed to use any imports, except for the ones given (if any).
You may not use any lists or list methods, for the same reasons as last week.
Please also do not use try-except statements, you should be able to anticipate
or prevent any errors from happening at all!
"""


def is_palindrome(string: str) -> bool:
    """
    Your "is_palindrome" implementation from last week (Lab 3), which you may
    use as is or with modifications if you didn't get it right last time.

    Keep in mind when making any modifications that the restrictions from lab 3
    still apply to this function, this means that you cannot use any loops,
    "if" statements, or anything that was disallowed in the previous lab.
    """
    cleaned_string = string.replace(" ", "").lower().strip()
    return cleaned_string == cleaned_string[::-1]


def is_palindrome_string(string: str) -> bool:
    """
    Given a string <string>, return whether this string is a palindrome string.

    For the purposes of this function, a palindrome string is any string that
    forms a palindrome if you piece together the first letter of every word in
    the string. We define a word here to be ANY CONTINUOUS SEGMENT OF
    ALPHABETICAL CHARACTERS. That means that "abc;def", has two words: "abc"
    and "def". The separating character does not have to be whitespace, and
    there could be more than one separating character between two words.

    Since you will be using your is_palindrome function from last week, the
    definition of a palindrome will remain the same as the definition from
    last week (ignore capitalization and whitespace).

    A simple example: given the string "test string test", there are three
    words, "test", "string", and "test". The first letters of each word come
    together to form the string "tst". And since "tst" is a palindrome, this
    function should return True for the input "test string test".

    Precondition: <string> will contain at least one word.

    Restrictions: you must use your "is_palindrome" function from lab 3 as a
                  helper for this function, in addition to the lab restrictions
                  defined at the start of this file. You are allowed and are
                  encouraged to fix any issues with your previous submission
                  for this function.
    """
    #clean up string 
    cleaned_string=""
    for char in string:
        if char.isalpha():          #char.isspace()
            cleaned_string += char      #cleaned_string+=''
        else:
            cleaned_string += ' '      #cleaned_string+=char
   
    # split string into substrings
    # get first letter of each substring
    first_letter_of_each_word ='' 
    for word in cleaned_string.split():
        first_letter_of_each_word = first_letter_of_each_word + word[0]
    return is_palindrome(first_letter_of_each_word)

print(is_palindrome_string('B1!@#A'))

def reverse_sentence(s: str) -> str:
    """
    Given a sentence <s>, we define a word within <s> to be a continuous
    sequence of characters in <s> that starts with a capital letter and
    ends before the next capital letter in the string or at the end of
    the string, whichever comes first. A word can include a mixture of
    punctuation and spaces.

    This means that in the string 'ATest string!', there are in fact only two
    words: 'A' and 'Test string!'. Again, keep in mind that words start with a
    capital letter and continue until the next capital letter or the end of the
    string, which is why we consider 'Test string!' as one word.

    This function will reverse each word found in the string, and return a new
    string with the reversed words, as illustrated in the doctests below.

    >>> reverse_sentence('ATest string!')
    'A!gnirts tseT'

    >>> reverse_sentence('another String')
    'another gnirtS'
    """
    # for each word in s
    # store current word in a temp varilable
    # till next word, we reverse current word
    # add the reversed word to final output
    result=''#A
    current_word = '' #Test string!
    prev_capital_found=False
    for char in s:        #'ATest string!'
        if not char.isupper():
            current_word+=char
        else: #T
            # process last word 
            if prev_capital_found == True:
                current_word=current_word[::-1] #'A'
            result+=current_word
            current_word=''

            # start new word
            prev_capital_found=True
            current_word+=char
    
    if prev_capital_found == True:
        current_word=current_word[::-1]
    result+=current_word
    return result


#print(reverse_sentence('ATest string!'))
#print(reverse_sentence('another String'))