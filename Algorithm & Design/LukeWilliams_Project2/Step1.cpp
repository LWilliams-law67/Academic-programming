/*
 *      File  : main_project2.cpp
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : The main function for project 2. Implements a menu for scheduling and removing appointments
 *			as well as prints the schedule to the console. Also implements searching for doctors & patients.
 */

#include <iostream>
#include "DoctorList.h"
#include "PatientList.h"

using namespace std;

int main(int argc, char** argv)
{
	cout << "PATIENTS:\n" << endl;
	for (int i = 0; i < PatientList::size; i++)
	cout << PatientList::patients[i].patName << " " << PatientList::patients[i].patAge << " " << PatientList::patients[i].patGender << endl;
	//prints the list of patients when member variables are public

	cout << "\n" << endl;

	cout << "DOCTORS:\n" << endl;
	for (int i = 0; i < DoctorList::size; i++)
	cout << DoctorList::doctors[i].docName << " " << DoctorList::doctors[i].docAge << " " << DoctorList::doctors[i].docSpecialty << endl;
	//prints the list of doctors when variable members are public

	return 0;
}
