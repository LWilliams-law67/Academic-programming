/*
 *      File  : main_project2.cpp
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : The main function for project 2. Implements a menu for scheduling and removing appointments
 *			as well as prints the schedule to the console. Also implements searching for doctors & patients.
 */

#include <iostream>
//#include "appointment.h"

using namespace std;

int main(int argc, char** argv)
{
	int menu = 0;			//used for exiting the menu loop
	int menuSelection;		//used for receiving user input for menu selections
	int search;				//allows user to select doctor or patient search
	string doctor;			//for user to input doctor's name to search
	string patient;			//for user to input patient's name to search

	while(menu != 5)
	{
		cout << "1) Search		2) Add appointment		3) Remove appointment		4) View Schedule		5) Exit" << endl;
		cout << endl;
		cout << "Choose an option then press ENTER: ";
		cin >> menuSelection;	//user inputs a menu option

		switch (menuSelection)	//arguments for user's menuSelection
		{
			case 1:
					cout << "Search for: 	1) Doctor		2) Patient\n";
					cin >> search;
					cout << endl;

					switch (search)
					{
						case 1:
							cout << "Which doctor are you searching for: \n";
							cin >> doctor;
							cout << endl;
							//add funciton calls to find and print doctor info and schedule
							break;

						case 2:
							cout << "Which patient are you searching for: \n";
							cin >> patient;
							cout << endl;
							//add function calls to find and print patient info and appointments
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
