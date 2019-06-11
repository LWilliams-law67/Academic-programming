/*
 *      File  : main_project2.cpp
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : setting up appointment functionality and searching capability
 */
 
#include <iostream>
#include <string>

using namespace std;

int main()
{
	
	int compare, found;
	string patient;
	string doctor;
	const char* patient_ptr = patient.c_str();
	const char* doctor_ptr = doctor.c_str();
	char* schedule[5][9];
/*	
	cout << "input name to compare: ";
	getline(cin,patient);
	cout << endl;
	cout << "input doctor to compare: ";
	getline(cin,doctor);
	cout << endl;
	
	for(int i = 0; i < 5; i++)
	{
		int compare = patient.compare(doctor);	//use DoctorList::doctors[i] instead of 'doctor'
		
		if (compare != 0)
			continue;
		else
			compare = i;
	}
	
	cout << compare;
	
	char* schedule[5][9];
	
	for(int i = 0; i < 5; i++)
		for(int j = 1; j < 9; j++)
			schedule[i][j] = &patient[0];
	
	for(int i = 0; i < 5; i++)
		schedule[i][0] = &doctor[0];
		
	for(int i = 0; i < 5; i++)
	{
		cout << endl;
		for(int j = 0; j < 9; j++)
			cout << schedule[i][j] << " ";
	}
	
	to find doctor/patient figure out how to use this:
    size_t found = schedule.find(doctor); 
    if (found != string::npos) 
        return found;


//set schedule with doctors and open appointments
	for(int i = 0; i < 5; i++)
	{
		//schedule[i][0] = &doctor[0];	//replace &doctor[0] with Doctor::docName 
		for(int j = 1; j < 9; j++)
			schedule[i][j] = "open\0";
	}
//view dcoctor's schedule
cout << "search for a doctor: ";
getline(cin,doctor);
cout << endl;

	for(int i = 0; i < 5; i++)
	{
		int compare = doctor.compare(schedule[i][0]);
		if (compare != 0)
			continue;
		else
		{
			compare = i;	//sets the value of compare to the location of search match
			for(int j = 0; j < 9; j++)	//a loop to print schedule for searched doctor
				cout << schedule[compare][j] << " ";
		}
		cout << endl;
		break; //exits loop when match is found and printed
	}
//to add or remove appointment in the schedule compare patient
//in a for loop until the patients appointment is located via compare as above
//then set that location to patient's name or "open\0" respectively
		
	
	for(int i = 0; i < 5; i++)
	{
		cout << endl;
		for(int j = 0; j < 9; j++)
			cout << schedule[i][j] << " ";
	}
*/


	return 0;
}

