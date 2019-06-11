/*
	Author: Luke Williams
	Date: September 29, 2017
	Description: Chapter 2 programming exercise 7 for CIS 251
				converting seconds to Hours:Minutes:Seconds
*/

#include <iostream>
using namespace std;

int main()

{
	int input, MINUTES, HOURS, SECONDS;
	
	cout << "Input the elapsed time for the event in seconds: ";
	cin >> input;
	cout << endl;
	
	MINUTES = input / 60;
	HOURS = MINUTES / 60;
	MINUTES = MINUTES % 60;
	SECONDS = input % 60 % 60;
		
	cout << "Event time: " << HOURS << ":" << MINUTES << ":" << SECONDS << endl;
	
	return 0;
}


