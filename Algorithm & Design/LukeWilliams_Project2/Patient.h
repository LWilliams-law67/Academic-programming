/*
 *      File  : Patient.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : The declaration of the class that contains the initialized members
 *              of a Patient awaiting to be scheduled for the day.
 */
 
#include <iostream>
//#include <string>
 
#ifndef PATIENT_H_
#define PATIENT_H_

 class Patient
 {
 	private:
 		char* patName;
 		char* patGender;
 		int patAge;
 		
 	public:
 		Patient(char* name, int age, char* gender)
 		{
 			patName = name;
 			patAge = age;
 			patGender = gender;
		};
 		char* getPatName();
 		int getPatAge();
 		char* getPatGender();

 };
 
#endif

