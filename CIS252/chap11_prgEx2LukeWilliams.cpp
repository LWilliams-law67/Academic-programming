/*
	Author: Luke Williams
	Date: 24 April 2018
	Description: Chapter 11 program 2: user inputs the number of lines for a pattern and the program
				uses a recursive function to print out a pattern as follows
				*
				**
				***
				**
				*
				using the number of lines specified.
*/

#include<iostream>
#include<cstdlib>
#include<cmath>
#include<iomanip>
#include<ctime>

using namespace std;

void recPattern(int numLines, int general = 1);

int main()
{
	int lines = 0;
	
	cout << "Please enter the number of lines you desire for this pattern: ";
	cin >> lines;
	cout << endl;
	
	recPattern(lines);
	
	return 0;
}

void recPattern(int numLines, int general)
{
	if(general <= numLines)
	{
		for(int i=0; i<general; i++)
			cout << "*";
		cout << endl;
	}
	
	else if(general > numLines)
	{
		for(int i=0; i<numLines; i++)
			cout << "*";
		cout << endl;
	}
	
	if(general <= numLines)
	{
		general++;
		recPattern(numLines, general);
	}
	
	else if(general > numLines && numLines != 1)
	{
		numLines--;
		recPattern(numLines, general);
	}	
}
