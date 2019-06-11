/*
	Author: Luke Williams
	Date: September 29, 2017
	Description: Chapter 2 Programming exercise 2 for CIS 251
*/

#include <iostream>
using namespace std;

int main()

{
	int num2;
	double num1;
	
	cout << "Please type a decimal number: ";
	cin >> num1;
	cout << endl;
	
	num2 = static_cast<int>(num1 + .5);
	cout << "Your number rounds to: " << num2 << endl;
	
	return 0;
}
