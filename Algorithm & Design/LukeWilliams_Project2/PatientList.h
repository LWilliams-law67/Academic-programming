/*
 *      File  : PatientList.h
 *      Author: Ricky Landry (rlandry)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : The declaration of the class that contains the initialized list
 *              of patients available to be scheduled for the day.
 */

#ifndef PATIENTLIST_H_
#define PATIENTLIST_H_

#include "Doctor.h"
#include "Patient.h"

class PatientList
{
public:
    static Patient patients[];
    static const int size;
};

#endif /* PATIENTLIST_H_ */
