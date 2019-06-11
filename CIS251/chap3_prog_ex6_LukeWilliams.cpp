/*
	Author: Luke Williams
	Date: 23 October 2017
	Description: Chapter 3 programming exercise 6 mimics a calculator for the simple math problems
*/

#include <iostream>
#include <iomanip>
#include <typeinfo>
using namespace std;
int main()

{
	double a, b;
	char math;
	
	cout << "Using addition, subtraction, multiplication or division;" << endl;
	cout << "for example, 3+4 or 9.7*6" << endl;
	cout << "Please enter a simple math problem: ";
	cin >> a >> math >> b;
	cout << endl;

	if (static_cast<char>(math) == '+')
		{
			cout << a << static_cast<char>(math) << b << "=";
			if (a+b == static_cast<int>(a+b))
				cout << fixed << setprecision(0) << a+b << endl;
			else cout << fixed << setprecision(4) << a+b << endl;
		}
	else if (static_cast<char>(math) == '-')
			{
			cout << a << static_cast<char>(math) << b << "=";
			if (a-b == static_cast<int>(a-b))
				cout << fixed << setprecision(0) << a-b << endl;
			else cout << fixed << setprecision(4) << a-b << endl;
			}
		else if (static_cast<char>(math) == '*')
				{
				cout << a << static_cast<char>(math) << b << "=";
				if (a*b == static_cast<int>(a*b))
				cout << fixed << setprecision(0) << a*b << endl;
				else cout << fixed << setprecision(4) << a*b << endl;
				}
			else {
					cout << a << static_cast<char>(math) << b << "=";
					if (a/b == static_cast<int>(a/b))
					cout << fixed << setprecision(0) << a/b << endl;
					else cout << fixed << setprecision(4) << a/b << endl;
				}
			
	return 0;
}
