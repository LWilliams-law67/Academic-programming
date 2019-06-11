/*
	Author: Luke Williams
	September 18, 2017
	Chapter 1 Programming Exercise 7
*/

#include <iostream>																					//A.
using namespace std;																				//B.

int main ()

{
	const int SECRET = 11;																			//C.
	const double RATE = 12.50;
	
	int num1, num2, newNum;																			//D.
	string name;
	double hoursWorked, wages;
	
	num1 = 15;																						//E.
	num2 = 28;
	
	cout << "The value of num1 = " << num1 << " and the value of num2 = " << num2 << endl;			//F.
	cout << " " << endl;
	
	newNum = num1 * 2 + num2;																		//G.
	cout << "The value of newNum = " << newNum << endl;
	cout << " " << endl;
	
	newNum = newNum + SECRET;																		//H.
	cout << "The SECRET value of newNum is " << newNum << endl;
	
	name = "Cynthia Jacobson";																		//I.
	
	hoursWorked = 45.50;																			//J.
	
	wages = RATE * hoursWorked;																		//K.
	
	cout << " " << endl;																
	cout << " " << endl;
	cout << "Name: " << name << endl;																//L.
	cout << "Pay Rate: $" << RATE << endl;
	cout << "Hours Worked: " << hoursWorked << endl;
	cout << "Salary: $" << wages << endl;
	
	return 0;
}
