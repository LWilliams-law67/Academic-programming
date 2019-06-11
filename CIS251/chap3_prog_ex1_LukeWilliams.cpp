/*
	Author: Luke Williams
	Date: 23 October 2017\
	Description: Chapter 3 programming exercise 1 user inputs a number and the computer outputs whether the number is positive or negetive
*/

#include <iostream>
using namespace std;
int main()
{
	double a;
	cout << "Please type a number then hit ENTER: ";
	cin >> a;
	cout << endl;
	
	if (a>0)
		cout << "Your number is " << a << ", and it is positive." << endl;
	else if (a<0)
			cout << "Your number is " << a << ", and it is negative." << endl;
		else cout << "Your number is " << a << ", and it is neither positive or negative." << endl;
		
	return 0;
}
