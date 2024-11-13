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

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>
#include <string.h>
#include <ctype.h>
#include "core.h"

//////////////////////////////////////
// USER INTERFACE FUNCTIONS
//////////////////////////////////////

// Clear the standard input buffer
void clearInputBuffer(void)
{
    // Discard all remaining char's from the standard input buffer:
    while (getchar() != '\n')
    {
        ; // do nothing!
    }
}

// Wait for user to input the "enter" key to continue
void suspend(void)
{
    printf("\n");
    printf("<ENTER> to continue...");
    clearInputBuffer();
    putchar('\n');
}


int inputInt(void) {
    int num;
    char term;
    while (scanf("%d%c", &num, &term) != 2 || term != '\n') {
        clearInputBuffer();
        printf("Error! Please enter an integer: ");
    }
    return num;
}

int inputIntPositive(void) {
    int num;
    do {
        num = inputInt();
        if (num < 1) {
            printf("Error! Please enter a positive integer: ");
        }
    } while (num < 1);
    return num;
}

int inputIntRange(int lower, int upper) {
    int num;
    do {
        num = inputInt();
        if (num < lower || num > upper) {
            printf("Error! Please enter an integer between %d and %d: ", lower, upper);
        }
    } while (num < lower || num > upper);
    return num;
}

char inputCharOption(const char* validChars) {
    char input, temp;
    do {
        scanf(" %c%c", &input, &temp);
        if (temp != '\n' || strchr(validChars, input) == NULL) {
            clearInputBuffer();
            printf("ERROR: Character must be one of [%s]: ", validChars);
        }
        else {
            return input;
        }
    } while (1);
}


void inputCString(char* str, int min, int max) {
    do {
        if (fgets(str, max + 2, stdin)) {  // max + 2 to read possibly one extra character for '\n'
            size_t len = strlen(str);
            if (str[len - 1] == '\n') {
                str[len - 1] = '\0';
                len--;
            }
            else {
                clearInputBuffer();
            }
            if (len < min) {
                printf("ERROR: String length must be at least %d chars: ", min);
            }
            else if (len > max) {
                printf("ERROR: String length must be no more than %d chars: ", max);
                fflush(stdout);  // ˢ�������������ȷ��������Ϣ����ʾ
                continue;  // ����ѭ������ʾ�û���������
            }
            else {
                break;  // ��ȷ���룬�˳�ѭ��
            }
        }
        else {
            clearInputBuffer();  // ���� EOF ����������
            break;
        }
    } while (1);
}

void inputDigits(char* str, int length) {
    while(1){
        if(fgets(str, length+2, stdin)){
            size_t len = strlen(str);
            if(len != length){
                printf("Invalid 10-digit number! Number: ");
                clearInputBuffer();
                fflush(stdout);
            }else{
                break;
            }
        }
        else{
            clearInputBuffer();
            break;
        }
    }
}



void displayFormattedPhone(const char* phoneNumber) {
    if (phoneNumber[0] == '\0') {
        printf("(___)___-____");
    }
    else {
        printf("(%c%c%c)%c%c%c-%c%c%c%c",
            phoneNumber[0], phoneNumber[1], phoneNumber[2],
            phoneNumber[3], phoneNumber[4], phoneNumber[5],
            phoneNumber[6], phoneNumber[7], phoneNumber[8], phoneNumber[9]);
    }
}
void someFunction() {
    char* str = "example";
    size_t len = strlen(str);
    printf("Length of the string is: %zu\n", len);
}