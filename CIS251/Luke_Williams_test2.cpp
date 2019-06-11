/*
	Author: Luke Williams
	Date: 11 November 2017
	Description: Test 2 hands on programming application
					user inputs three values, and the program outputs the average
*/

#include<iostream>
#include<iomanip>

using namespace std;

int main()

{
	double inp1, inp2, inp3;
	
	cout << "Please input three numbers, then press ENTER: ";
	cin >> inp1 >> inp2 >> inp3;
	cout << endl;
	
	cout << fixed << showpoint << setprecision(1);
	cout << "The average of your numbers is: " << (inp1+inp2+inp3)/3 << endl;
	
	return 0;
}
