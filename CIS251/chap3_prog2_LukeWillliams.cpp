/*
	Author: Luke Williams
	Date: 20 October 2017
	Description: Chapter 3 programming exercise 2, user inputs three numbers then the numbers are printed in ascending order
*/

#include <iostream>
#include <iomanip>

using namespace std;

int main()

{
	double a, b, c;
	cout << "Please input three numbers seperated by spaces: ";
	cin >> a >> b >> c;
	
	if (a < b && a < c)
		cout << a << endl;
	else if (b < a && b < c)
			cout << b << endl;
		else cout << c << endl;
	
	if (a > b && a < c)
		cout << a << endl;
	else if (a > c && a < b)
			cout << a << endl;
		else if (b > c && b < a)
				cout << b << endl;
			else if (b > a && b < c)
					cout << b << endl;
				else cout << c << endl;
		
	if (a > b && a > c)
		cout << a << endl;
	else if (b > a && b > c)
			cout << b << endl;
		else cout << c << endl;
		
	return 0;
}
