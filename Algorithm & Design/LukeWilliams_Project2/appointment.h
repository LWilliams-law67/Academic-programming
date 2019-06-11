/*
 *      File  : appointment.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : The declaration of the class that contains the initialized members
 *              of appointments for viewing, adding, and removing from the schedule for the day.
 */
 
#include <iostream>
#include <string>
 
#ifndef APPOINTMENT_H_
#define APPOINTMENT_H_

 class appointment
 {
 	private:
 		char* schedule[5][9];
 		char timeSlot[5] = "Open";
 		
 	public:
 		appointment();
 		char* addApp(char* name);
 		char* removeApp(char* name);
 		char* getSchedule(char* name);
 		void setSchedule();
 		void printFullSchedule();
 };
 
#endif
 
