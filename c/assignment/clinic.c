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
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "core.h"
#include "clinic.h"

Date getDate() {
    Date date;
    printf("Enter year, month, and day (YYYY MM DD): ");
    scanf("%d %d %d", &date.year, &date.month, &date.day);
    return date;
}

Time getTime() {
    Time time;
    printf("Enter hour and minute (HH MM): ");
    scanf("%d %d", &time.hour, &time.minute);
    return time;
}
//////////////////////////////////////
// DISPLAY FUNCTIONS
//////////////////////////////////////

// !!! DO NOT MODIFY THIS FUNCTION DEFINITION !!!
// Display's the patient table header (table format)
void displayPatientTableHeader(void)
{
    printf("Pat.# Name            Phone#\n"
           "----- --------------- --------------------\n");
}

// !!! DO NOT MODIFY THIS FUNCTION DEFINITION !!!
// Displays a single patient record in FMT_FORM | FMT_TABLE format
void displayPatientData(const struct Patient* patient, int fmt)
{
    if (fmt == FMT_FORM)
    {
        printf("Name  : %s\n"
               "Number: %05d\n"
               "Phone : ", patient->name, patient->patientNumber);
        displayFormattedPhone(patient->phone.number);
        printf(" (%s)\n", patient->phone.description);
    }
    else
    {
        printf("%05d %-15s ", patient->patientNumber,
               patient->name);
        displayFormattedPhone(patient->phone.number);
        printf(" (%s)\n", patient->phone.description);
    }
}

// !!! DO NOT MODIFY THIS FUNCTION DEFINITION !!!
// Display's appointment schedule headers (date-specific or all records)
void displayScheduleTableHeader(const struct Date* date, int isAllRecords)
{
    printf("Clinic Appointments for the Date: ");

    if (isAllRecords)
    {
        printf("<ALL>\n\n");
        printf("Date       Time  Pat.# Name            Phone#\n"
               "---------- ----- ----- --------------- --------------------\n");
    }
    else
    {
        printf("%04d-%02d-%02d\n\n", date->year, date->month, date->day);
        printf("Time  Pat.# Name            Phone#\n"
               "----- ----- --------------- --------------------\n");
    }
}

// !!! DO NOT MODIFY THIS FUNCTION DEFINITION !!!
// Display a single appointment record with patient info. in tabular format
void displayScheduleData(const struct Patient* patient,
    const struct Appointment* appoint,
    int includeDateField)
{
    if (includeDateField)
    {
        printf("%04d-%02d-%02d ", appoint->date.year, appoint->date.month,
              appoint->date.day);
    }
    printf("%02d:%02d %05d %-15s ", appoint->time.hour, appoint->time.minute,
            patient->patientNumber, patient->name);

    displayFormattedPhone(patient->phone.number);

    printf(" (%s)\n", patient->phone.description);
}



//////////////////////////////////////
// MENU & ITEM SELECTION FUNCTIONS
//////////////////////////////////////

// !!! DO NOT MODIFY THIS FUNCTION DEFINITION !!!
// main menu
void menuMain(struct ClinicData* data)
{
    int selection;

    do {
        printf("Veterinary Clinic System\n"
               "=========================\n"
               "1) PATIENT     Management\n"
               "2) APPOINTMENT Management\n"
               "-------------------------\n"
               "0) Exit System\n"
               "-------------------------\n"
               "Selection: ");
        selection = inputIntRange(0, 2);
        putchar('\n');
        switch (selection)
        {
        case 0:
            printf("Are you sure you want to exit? (y|n): ");
            selection = !(inputCharOption("yn") == 'y');
            putchar('\n');
            if (!selection)
            {
                printf("Exiting system... Goodbye.\n\n");
            }
            break;
        case 1:
            menuPatient(data->patients, data->maxPatient);
            break;
        case 2:
            menuAppointment(data);
            break;
        }
    } while (selection);
}

// !!! DO NOT MODIFY THIS FUNCTION DEFINITION !!!
// Menu: Patient Management
void menuPatient(struct Patient patient[], int max)
{
    int selection;

    do {
        printf("Patient Management\n"
               "=========================\n"
               "1) VIEW   Patient Data\n"
               "2) SEARCH Patients\n"
               "3) ADD    Patient\n"
               "4) EDIT   Patient\n"
               "5) REMOVE Patient\n"
               "-------------------------\n"
               "0) Previous menu\n"
               "-------------------------\n"
               "Selection: ");
        selection = inputIntRange(0, 5);
        putchar('\n');
        switch (selection)
        {
        case 1:
            displayAllPatients(patient, max, FMT_TABLE);
            suspend();
            break;
        case 2:
            searchPatientData(patient, max);
            break;
        case 3:
            addPatient(patient, max);
            suspend();
            break;
        case 4:
            editPatient(patient, max);
            break;
        case 5:
            removePatient(patient, max);
            suspend();
            break;
        }
    } while (selection);
}

// !!! DO NOT MODIFY THIS FUNCTION DEFINITION !!!
// Menu: Patient edit
void menuPatientEdit(struct Patient* patient)
{
    int selection;

    do {
        printf("Edit Patient (%05d)\n"
               "=========================\n"
               "1) NAME : %s\n"
               "2) PHONE: ", patient->patientNumber, patient->name);
        
        displayFormattedPhone(patient->phone.number);
        
        printf("\n"
               "-------------------------\n"
               "0) Previous menu\n"
               "-------------------------\n"
               "Selection: ");
        selection = inputIntRange(0, 2);
        putchar('\n');

        if (selection == 1)
        {
            printf("Name  : ");
            inputCString(patient->name, 1, NAME_LEN);
            putchar('\n');
            printf("Patient record updated!\n\n");
        }
        else if (selection == 2)
        {
            inputPhoneData(&patient->phone);
            printf("\n");
            printf("Patient record updated!\n\n");
        }

    } while (selection);
}


// !!! DO NOT MODIFY THIS FUNCTION DEFINITION !!!
// Menu: Appointment Management
void menuAppointment(struct ClinicData* data) {
    int selection;
    do {
        printf("Appointment Management\n"
            "==============================\n"
            "1) VIEW ALL Appointments\n"
            "2) VIEW Appointments by DATE\n"
            "3) ADD Appointment\n"
            "4) REMOVE Appointment\n"
            "------------------------------\n"
            "0) Previous menu\n"
            "------------------------------\n"
            "Selection: ");
        selection = inputIntRange(0, 4);
        putchar('\n');
        switch (selection) {
        case 1:
            viewAllAppointments(data->appointments, data->maxAppointments); // ToDo: You will need to create this function!
            suspend();
            break;
        case 2:
            viewAppointmentSchedule(data->appointments, data->maxAppointments); // ToDo: You will need to create this function!
            suspend();
            break;
        case 3:
            addAppointment(data->appointments, data->maxAppointments); // ToDo: You will need to create this function!
            suspend();
            break;
        case 4:
            removeAppointment(data->appointments, data->maxAppointments); // ToDo: You will need to create this function!
            suspend();
            break;
        }
    } while (selection);
}


// ---------------------------------------------------------------------------
// !!! INSERT/COPY YOUR MS#2 FUNCTION DEFINITIONS BELOW... !!!
// Note: Maintain the same order/sequence as it is listed in the header file
//       Properly organize/categorize any new functions accordingly
// ---------------------------------------------------------------------------


void displayAllPatients(const struct Patient patient[], int max, int fmt) {
    int i, found = 0;
    displayPatientTableHeader();
    for (i = 0; i < max; i++) {
        if (patient[i].patientNumber != 0) {
            displayPatientData(&patient[i], fmt);
            found = 1;
        }
    }
    if (!found) {
        printf("*** No records found ***\n");
    }
}




void searchPatientData(const struct Patient patient[], int max) {
    char option;
    printf("Search Options\n"
        "==========================\n"
        "1) By patient number\n"
        "2) By phone number\n"
        "..........................\n"
        "0) Previous menu\n"
        "..........................\n"
        "Selection: ");
    option = inputCharOption("012");
    putchar('\n');
    if (option == '1') {
        searchPatientByPatientNumber(patient, max);
    }
    else if (option == '2') {
        searchPatientByPhoneNumber(patient, max);
    }
    else if (option == '0') {
        return;
    }
}


void addPatient(struct Patient patient[], int max) {
    int i;
    for (i = 0; i < max; i++) {
        if (patient[i].patientNumber == 0) {
            patient[i].patientNumber = nextPatientNumber(patient, max);
            inputPatient(&patient[i]);
            printf("\n*** New patient record added ***\n");
            return;
        }
    }
    printf("ERROR: Patient listing is FULL!\n");
}



void editPatient(struct Patient patient[], int max) {
    int patientNumber, index;
    printf("Enter the patient number: ");
    patientNumber = inputInt();
    printf("\n");
    index = findPatientIndexByPatientNum(patientNumber, patient, max);
    if (index != -1) {
        menuPatientEdit(&patient[index]);
    }
    else {
        printf("\nERROR: Patient record not found!\n");
    }
}


void removePatient(struct Patient patient[], int max) {
    int patientNumber, index;
    printf("Enter the patient number: ");
    patientNumber = inputInt();
    printf("\n");
    index = findPatientIndexByPatientNum(patientNumber, patient, max);
    if (index != -1) {
        displayPatientData(&patient[index], FMT_FORM);
        printf("\nAre you sure you want to remove this patient record? (y/n): ");
        char choice = inputCharOption("yn");
        if (choice == 'y') {
            patient[index].patientNumber = 0;
            printf("Patient record has been removed!\n");
        }
        else {
            printf("Operation aborted.\n");
        }
    }
    else {
        printf("ERROR: Patient record not found!\n");
    }
}
void displayAppointment(const Appointment* appoint) {
    printf("%02d:%02d %d %s\n", appoint->time.hour, appoint->time.minute, appoint->patientNumber, appoint->name);
}


// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// Milestone #3 mandatory functions...
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

// View ALL scheduled appointments
void viewAllAppointments(const Appointment appointments[], int maxAppointments) {
    int i;
    for (i = 0; i < maxAppointments; i++) {
        if (appointments[i].patientNumber != 0) {
            displayAppointment(&appointments[i]);
        }
    }
}



// View appointment schedule for the user input date
void viewAppointmentSchedule(const Appointment appointments[], int maxAppointments) {
    Date inputDate;
    printf("Enter date (YYYY MM DD): ");
    scanf("%d %d %d", &inputDate.year, &inputDate.month, &inputDate.day);
    clearInputBuffer();

    int i, count = 0;
    for (i = 0; i < maxAppointments; i++) {
        if (appointments[i].patientNumber > 0 && isEqualDate(appointments[i].date, inputDate)) {
            displayAppointment(&appointments[i]);
            count++;
        }
    }
    if (count == 0) {
        printf("No appointments found for %d-%d-%d.\n", inputDate.year, inputDate.month, inputDate.day);
    }
}




// Add an appointment record to the appointment array
void addAppointment(Appointment appointments[], int maxAppointments) {

    int i;
    for (i = 0; i < maxAppointments && appointments[i].patientNumber != 0; i++);

    if (i == maxAppointments) {
        printf("No space to add more appointments.\n");
        return;
    }

    appointments[i].patientNumber = getPatientNumber();
   
    appointments[i].date = getDate();
    appointments[i].time = getTime();
    printf("Appointment added successfully.\n");
}



// Remove an appointment record from the appointment array
void removeAppointment(Appointment appointments[], int maxAppointments) {
    int patientNumber, index = -1;
    printf("Enter patient number of the appointment to remove: ");
    scanf("%d", &patientNumber);
    clearInputBuffer();
    int i;
    for (i = 0; i < maxAppointments; i++) {
        if (appointments[i].patientNumber == patientNumber) {
            index = i;
            break;
        }
    }

    if (index == -1) {
        printf("Appointment not found.\n");
        return;
    }
    if (confirmRemoval()) {
        appointments[index].patientNumber = 0;
        printf("Appointment removed.\n");
    }
    else {
        printf("Removal canceled.\n");
    }
}



//////////////////////////////////////
// UTILITY FUNCTIONS
//////////////////////////////////////

// Search and display patient record by patient number (form)
void searchPatientByPatientNumber(const struct Patient patient[], int max) {
    int patientNumber, found = 0;
    printf("Search by patient number: ");
    patientNumber = inputInt();
    printf("\n");
    int i;
    for (i = 0; i < max; i++) {
        if (patient[i].patientNumber == patientNumber) {
            printf("Name  : %s\nNumber: %05d\nPhone : ", patient[i].name, patient[i].patientNumber);
            displayFormattedPhone(patient[i].phone.number);
            printf(" (%s)\n", patient[i].phone.description);
            found = 1;
            break;
        }
    }
    if (!found) {
        printf("*** No records found ***\n");
    }
    suspend();
    searchPatientData(patient, max);
}


// Search and display patient records by phone number (tabular)
void searchPatientByPhoneNumber(const struct Patient patient[], int max) {
    char phoneNumber[PHONE_LEN + 1];
    int found = 0;
    int i; 
    printf("Search by phone number: ");
    inputCString(phoneNumber, PHONE_LEN, PHONE_LEN);
    printf("\n");
    for (i = 0; i < max; i++) {
        if (strcmp(patient[i].phone.number, phoneNumber) == 0) {
            if (!found)
                displayPatientTableHeader();
            printf("%05d %-15s ", patient[i].patientNumber, patient[i].name);
            displayFormattedPhone(patient[i].phone.number);
            printf(" (%s)\n", patient[i].phone.description);
            found = 1;



        }
    }
    if (!found) {
        displayPatientTableHeader();
        printf("\n*** No records found ***\n");
    }
    suspend();
    searchPatientData(patient, max);

}


// Get the next highest patient number
int nextPatientNumber(const struct Patient patient[], int max) {
    int i;
    int highestNumber = 0;
    for (i = 0; i < max; i++) {
        if (patient[i].patientNumber > highestNumber) {
            highestNumber = patient[i].patientNumber;
        }
    }
    return highestNumber + 1;
}


// Find the patient array index by patient number (returns -1 if not found)
int findPatientIndexByPatientNum(int patientNumber, const struct Patient patient[], int max) {
    int i;
    for (i = 0; i < max; i++) {
        if (patient[i].patientNumber == patientNumber) {
            return i;
        }
    }
    return -1;
}

int isEqualDate(const Date a, const Date b) {
    return a.year == b.year && a.month == b.month && a.day == b.day;
}
int getPatientNumber(void) {
    static int nextPatientNumber = 1;
    return nextPatientNumber++;
}
int confirmRemoval(void) {
    char response;
    printf("Confirm removal (Y/N): ");
    scanf(" %c", &response);
    return (response == 'Y' || response == 'y');
}

//////////////////////////////////////
// USER INPUT FUNCTIONS
//////////////////////////////////////

// Get user input for a new patient record
void inputPatient(struct Patient* patient) {
    printf("Patient Data Input\n");
    printf("------------------\n");
    printf("Number: %05d\n", patient->patientNumber);
    printf("Name  : ");
    inputCString(patient->name, 1, NAME_LEN);
    printf("\n");
    inputPhoneData(&patient->phone);



}



// Get user input for phone contact information
void inputPhoneData(struct Phone* phone) {
    printf("Phone Information\n");
    printf("-----------------\n");
    printf("How will the patient like to be contacted?\n");
    printf("1. Cell\n");
    printf("2. Home\n");
    printf("3. Work\n");
    printf("4. TBD\n");
    printf("Selection: ");
    int option = inputIntRange(1, 4);
    const char* types[] = { "CELL", "HOME", "WORK", "TBD" };
    strcpy(phone->description, types[option - 1]);  // 正确使用 strcpy 确保描述正确拷贝

    if (option != 4) {
        printf("\nContact: %s\n", types[option - 1]);
        printf("Number : ");
        inputDigits(phone->number, PHONE_LEN, PHONE_LEN);  // 确保在这里输入的电话号码是独立处理的
    }
    else {
        phone->number[0] = '\0';  // 对于 TBD 选项，电话号码设为空
    }
}




//////////////////////////////////////
// FILE FUNCTIONS
//////////////////////////////////////

// Import patient data from file into a Patient array (returns # of records read)
int importPatients(const char* datafile, struct Patient patients[], int max) {
    FILE* file = fopen(datafile, "r");
    if (!file) {
        printf("Error opening file\n");
        return -1;
    }

    int count = 0;
    char line[256];
    while (fgets(line, sizeof(line), file) && count < max) {
        line[strcspn(line, "\n")] = 0;
        if (sscanf(line, "%d|%49[^|]|%14[^|]|%10s", &patients[count].patientNumber,
            patients[count].name, patients[count].phone.description,
            patients[count].phone.number) == 4) {
            count++;
        }
        else if (sscanf(line, "%d|%49[^|]|TBD", &patients[count].patientNumber,
            patients[count].name) == 2) {
            strcpy(patients[count].phone.description, "TBD");
            patients[count].phone.number[0] = '\0';
            count++;
        }
        else {
            printf("Failed to parse line: %s\n", line);
        }
    }
    fclose(file);
    return count;
}


int importAppointments(const char* datafile, Appointment appointments[], int max) {
    FILE* file = fopen(datafile, "r");
    if (!file) {
        printf("Failed to open file: %s\n", datafile);
        return 0;
    }

    int count = 0;
    while (count < max) {
        int result = fscanf(file, "%d,%d,%d,%d,%d,%d",
            &appointments[count].patientNumber,
            &appointments[count].date.year,
            &appointments[count].date.month,
            &appointments[count].date.day,
            &appointments[count].time.hour,
            &appointments[count].time.minute);

        if (result != 6) {

            fscanf(file, "%*[^\n]");
        }
        else {
            count++;
        }

        if (feof(file)) {
            break;
        }
    }

    fclose(file);
    return count;
}




