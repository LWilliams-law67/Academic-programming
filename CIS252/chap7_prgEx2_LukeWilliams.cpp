/*
	Author: Luke Williams
	Date: 26 February 2018
	Description: This is not a functioning program. It is a class definition that can be used
				and implemented in a program.
*/

#include<iostream>
#include<string>

using namespace std;

class dayType
{
	
	string day;
	
	public:
		void setDay(string);
		void printDay(string) const;
		string returnDay();
		string tomorrow();
		string yesterday();
		string calculateDay();
		dayType();
		dayType(string);
				
};

int main()
{
	return 0;
}
