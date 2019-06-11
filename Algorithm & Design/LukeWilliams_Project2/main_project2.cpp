/*
 *      File  : main_project2.cpp
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : The main function for project 2. Implements a menu for scheduling and removing appointments
 *			as well as prints the schedule to the console. Also implements searching for doctors & patients.
 */

#include <iostream>
#include <string>
#include <ios>
#include <limits>
#include "DoctorList.h"
#include "PatientList.h"

using namespace std;


int main(int argc, char** argv) 
{
/*	cout << "PATIENTS:\n" << endl;
	
	for (int i = 0; i < PatientList::size; i++)
	{
		cout << PatientList::patients[i].getPatName() << " " << PatientList::patients[i].getPatAge() << " " << PatientList::patients[i].getPatGender() << endl;
		//prints the list of patients
	}
	cout << "\n" << endl;
	
	cout << "DOCTORS:\n" << endl;
	for (int i = 0; i < DoctorList::size; i++)
	{
		cout << DoctorList::doctors[i].getDocName() << " " << DoctorList::doctors[i].getDocAge() << " " << DoctorList::doctors[i].getDocSpecialty() << endl;
		//prints the list of doctors
	}
*/	

	int menu = 0;
	int menuSelection, search, compare;
	string doctor;
	string patient;
	
	while(menu != 5)
	{
		cout << "1) Search		2) Add appointment		3) Remove appointment		4) View Schedule		5) Exit" << endl;
		cout << endl;
		cout << "What would you like to do? ";
		cin >> menuSelection;
		cin.ignore(numeric_limits<streamsize>::max(),'\n');
		cout << "menuSelection is " << menuSelection;
		
		switch (menuSelection)
		{
			case 1:
					cout << "Search for: 	1) Doctor		2) Patient\n";
					cin >> search;
					cin.ignore(numeric_limits<streamsize>::max(),'\n');
					cout << "search is " << search << endl;
					
					switch (search)
					{
						case 1:
							cout << "Which doctor are you searching for: ";
							getline(cin, doctor);
							cin.ignore(numeric_limits<streamsize>::max(),'\n');
							cout << "doctor is " << doctor << endl;
							
							for(int i = 0; i < 5; i++)
							{
								compare = doctor.compare(DoctorList::doctors[i].getDocName());	
								if (compare != 0)
								{
									cout << compare << " ";
									continue;
								}
								
								else
								{
									compare = i;
									i = 5;
								}
							}
							if(compare == -1)
								break;
							
							cout << "Doctor: " << DoctorList::doctors[compare].getDocName();
							cout << "Age: " << DoctorList::doctors[compare].getDocAge();
							cout << "Specialty: " << DoctorList::doctors[compare].getDocSpecialty() << endl;
							
							break;
							
						case 2:
							cout << "Which patient are you searching for: \n";
							getline(cin, patient);
							cin.ignore(numeric_limits<streamsize>::max(),'\n');
							cout << patient << endl;

							for(int i = 0; i < 5; i++)
							{
								compare = patient.compare(PatientList::patients[i].getPatName());	
								if (compare != 0)
									continue;
								else
								{
									compare = i;
									i = 5;
								}
							}
							if(compare == -1)
								break;
								
							cout << "Patient: " << PatientList::patients[compare].getPatName();
							cout << "Age: " << PatientList::patients[compare].getPatAge();
							cout << "Gender: " << PatientList::patients[compare].getPatGender();
							
							break;	
					}

					break;
	  
			case 2:
					cout << "Patient's name: ";
					cin >> patient;
					cout << "Doctor's name: ";
					cin >> doctor;
					cout << endl;
					//add function calls to schedule an appointment
					break;
					
			case 3:
					cout << "Patient's name: ";
					cin >> patient;
					cout << "Doctor's name: ";
					cin >> doctor;
					cout << endl;
					//add function calls to remove an appointment
					break;
	
			case 4:
					cout << "Doctor's name: ";
					cin >> doctor;
					cout << endl;
					//add function call to view doctor's schedule
					break;
	
			case 5:
					menu = 5;	//sets menu==5 so the program will exit at the start of the next iteration
					break;
	
			default:
					cout << "Invalid input." << endl; //fail safe in case user input is not part of the menu options
					continue;
		}
	}
		return 0;
}

