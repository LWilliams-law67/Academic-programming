/*
	Author:
	Date:
	Description: Leap year seconds programming exercise user inputs a year and the program outputs if it is a leap year
*/

#include<iostream>
#include<string>
#include<iomanip>
#include<typeinfo>
using namespace std;

const int LEAPseconds = 366*24*3600;
const int NONLEAPseconds = 365*24*3600;
const int ENDPROG = -99;
const int SENTINEL = 5;

int main()
{
	int year;
	string input;
	
	cout << "*****NOTE: an entry of -99 will end the program*****" << endl;
	cout << "Please enter a year to determine if it is a leap year: ";
	cin >> year;
	cout << endl;

	
	
	while (year != SENTINEL)
	if (year > 0)
		if (year == -99)
			return 0;
		else if (year % 4 == 0)
			{
			if (year % 100 == 0)
				{
					if (year % 400 == 0)
						{
						cout << year << " is a leap year and has " << LEAPseconds << " seconds." << endl;
						cout << endl;
						cout << endl;
						cout << "*****NOTE: an entry of -99 will end the program*****" << endl;
						cout << "Please enter a year to determine if it is a leap year: ";
						cin >> year;
						cout << endl;
						}
					else {
						cout << year << " is not a leap year and has " << NONLEAPseconds << " seconds." << endl;
						cout << endl;
						cout << endl;
						cout << "*****NOTE: an entry of -99 will end the program*****" << endl;
						cout << "Please enter a year to determine if it is a leap year: ";
						cin >> year;
						cout << endl;
						}
				}
			else {
				cout << year << " is a leap year and has " << LEAPseconds << " seconds." << endl;
				cout << endl;
				cout << endl;
				cout << "*****NOTE: an entry of -99 will end the program*****" << endl;
				cout << "Please enter a year to determine if it is a leap year: ";
				cin >> year;
				cout << endl;
				}
			}
		else {
			cout << year << " is not a leap year and has " << NONLEAPseconds << " seconds." << endl;
			cout << endl;
			cout << endl;
			cout << "*****NOTE: an entry of -99 will end the program*****" << endl;
			cout << "Please enter a year to determine if it is a leap year: ";
			cin >> year;
			cout << endl;
			}
	else 
		{
		cout << year << " is not a valid year! " << endl;
		cout << endl;
		cout << endl;
		cout << "*****NOTE: an entry of -99 will end the program*****" << endl;
		cout << "Please enter a year to determine if it is a leap year: ";
		cin >> year;
		cout << endl;
		}
	return 0;
}
