/*
	Author: Luke Williams
	Date: December 4, 2017
	Description: Leap year seconds programming exercise user inputs a year and the program outputs if it is a leap year
*/

#include<iostream>
#include<string>
#include<iomanip>
#include<typeinfo>
using namespace std;

int LeapYear(int year);
const int LEAPseconds = 366*24*3600;
const int NONLEAPseconds = 365*24*3600;
const int ENDPROG = -99;
const int SENTINEL = 0;

int main()
{
	int year;
	
	cout << "*****NOTE: an entry of -99 will end the program*****" << endl;
	cout << "Please enter a year to determine if it is a leap year: ";
	cin >> year;
	cout << endl;

	if(year==ENDPROG)
		{
		cout << "Exiting the program..." << endl;
		return 0;
		}
	if(LeapYear(year)==0)
		cout << year << " is a leap, and has " << LEAPseconds << " seconds." << endl << endl;
	else if(LeapYear(year)==1)
			cout << year << " is not a leap year; therefore, it has " << NONLEAPseconds << " seconds." << endl << endl;
		else if(LeapYear(year)==-1)
				cout << year << " is an invalid year." << endl << endl;
return main();	
}

int LeapYear(int year)
{	
	if(year <= 0)
		return -1;
	if(year % 4 == 0)
		{
		if(year % 100 == 0)
			{
			if(year % 400 == 0)
					return 0;
			else
				return 1;
			}
		else
			return 1;
		}
	else
		return 1;	
}
