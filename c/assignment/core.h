/*/////////////////////////////////////////////////////////////////////////
                        Assignment 1 - Milestone 3
Full Name  : Junwen Li
Student ID#: 163891237
Email      : jli692@myseneca.ca
Section    : BTP100

Authenticity Declaration:
I declare this submission is the result of my own work and has not been
shared with any other student or 3rd party content provider. This submitted
piece of work is entirely of my own creation.
/////////////////////////////////////////////////////////////////////////*/

// SAFE-GUARD: 
// It is good practice to apply safe-guards to header files
// Safe-guard's ensures only 1 copy of the header file is used in the project build
// The macro name should be mirroring the file name with _ for spaces, dots, etc.

// !!! DO NOT DELETE THE BELOW 2 LINES !!!
#ifndef CORE_H
#define CORE_H

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
void clearInputBuffer(void);
void suspend(void);
int inputInt(void);
int inputIntPositive(void);
int inputIntRange(int lower, int upper);
char inputCharOption(const char* validChars);
void inputCString(char* str, int min, int max);
void displayFormattedPhone(const char* phoneNumber);
//
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


//////////////////////////////////////
// USER INTERFACE FUNCTIONS
//////////////////////////////////////

// Clear the standard input buffer
void clearInputBuffer(void);

// Wait for user to input the "enter" key to continue
void suspend(void);


//////////////////////////////////////
// USER INPUT FUNCTIONS
//////////////////////////////////////
int inputInt(void);

int inputIntPositive(void);


int inputIntRange(int lower, int upper);

char inputCharOption(const char* validChars);

void inputCString(char* str, int min, int max);

void inputDigits(char* str, int min, int max);

void displayFormattedPhone(const char* phoneNumber);



// !!! DO NOT DELETE THE BELOW LINE !!!
#endif // !CORE_H
