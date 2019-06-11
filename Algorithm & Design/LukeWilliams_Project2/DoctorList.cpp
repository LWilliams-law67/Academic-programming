/*
 *      File  : DoctorList.cpp
 *      Author: Ricky Landry (rlandry)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : The definition of the class that contains the initialized list
 *              of doctors available to be scheduled for the day.
 */

#include "DoctorList.h"

Doctor DoctorList::doctors[] = { {"Gerardo Socia",        45, "Ophthalmology"},
                                 {"Jeremy Porche",        31, "Neurology"},
                                 {"Tamiko Poat",          57, "Pediatrics"},
                                 {"Marjorie Weatherman",  27, "Rheumatology"},
                                 {"Cheyenne Stevenson",   35, "Cardiology"} };

const int DoctorList::size = sizeof(doctors)/sizeof(Doctor);
