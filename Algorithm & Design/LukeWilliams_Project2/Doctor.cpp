/*
 *      File  : Doctor.cpp
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : The definition of the class that contains the initialized members
 *              of a Doctor available to be scheduled for the day.
 */
 
#include <iostream>
//#include <string>
#include "DoctorList.h"

char* Doctor::getDocName()
 {
	 	return docName;
 }
 
int Doctor::getDocAge()
 {
 		return docAge;
 }
 
char* Doctor::getDocSpecialty()
 {
 		return docSpecialty;
 }

