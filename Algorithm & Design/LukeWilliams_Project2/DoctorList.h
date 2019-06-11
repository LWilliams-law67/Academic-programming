/*
 *      File  : DoctorList.h
 *      Author: Ricky Landry (rlandry)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : The declaration of the class that contains the initialized list
 *              of doctors available to be scheduled for the day.
 *
 */

#ifndef DOCTORLIST_H_
#define DOCTORLIST_H_

#include "Doctor.h"

class DoctorList
{
public:
    static Doctor doctors[];
    static const int size;
};

#endif /* DOCTORLIST_H_ */
