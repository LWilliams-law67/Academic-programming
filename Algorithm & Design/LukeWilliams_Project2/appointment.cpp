/*
 *      File  : appointment.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : The definition of the class that contains the initialized members
 *              of appointments for viewing, adding, and removing from the schedule for the day.
 */
 
#include <iostream>
#include <string>
#include "appointment.h"

using namespace std;
 		
char* appointment::addApp(char* name)
{
	
}

char* appointment::removeApp(char* name)
{
	
}

char* appointment::getSchedule(char* name)
{

}

void appointment::printFullSchedule()
{
	for(int i = 0; i < 5; i++)
	{
		cout << endl;
		for(int j = 0; j < 9; j++)
			cout << schedule[i][j] << " ";
	}
}

void appointment::setSchedule()
{
	//set schedule with doctors and open appointments
	for(int i = 0; i < 5; i++)
	{
		schedule[i][0] = DoctorList::doctors[0].getDocName() ;
		for(int j = 1; j < 9; j++)
			schedule[i][j] = &timeSlot[0];
	}
}
