/*
 *      File  : Doctor.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : The declaration of the class that contains the initialized members
 *              of a Doctor available to be scheduled for the day.
 */
 
#include <iostream>
//#include <string>

#ifndef DOCTOR_H_
#define DOCTOR_H_

 class Doctor
 {
 	private:
 		char* docName;
 		char* docSpecialty;
 		int docAge;
 		
 	public:
 		Doctor(char* name, int age, char* specialty)
		 {
		 	docName = name;
		 	docAge = age;
		 	docSpecialty = specialty;
		 };
 		char* getDocName();
 		int getDocAge();
 		char* getDocSpecialty();

 };

#endif


