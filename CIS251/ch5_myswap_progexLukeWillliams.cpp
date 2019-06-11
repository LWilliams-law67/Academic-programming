/*
	Author: Luke Williams
	Date: 20 October 2017
	Description: Chapter 3 programming exercise 2, user inputs three numbers then the numbers are printed in ascending order
*/

#include <iostream>
#include <iomanip>

using namespace std;
void mySWAP(int& a, int& b, int& c);
const char ENDPROG = 120;
int main()
{
	int num1, num2, num3;
	int swap = 0;
	cout << "To EXIT, enter three zeroes with spaces.\nPlease input three numbers seperated by spaces. Then press ENTER: ";
	cin >> num1 >> num2 >> num3;
	
	if((num1 == 0 && num2 == 0) && num3 == 0)
		return 0;
		
	if(num1 > num2)
		mySWAP(num1, num2, swap);
	
	if(num2 > num3)
		mySWAP(num2, num3, swap);

	if(num1 > num2)
		mySWAP(num1, num2, swap);
		
	cout << "\nYour numbers in ascending order are: " << endl;
	cout << num1 << " " << num2 << " " << num3 << "\n" << endl;
	
return main();
}
void mySWAP(int& a, int& b, int& c)
{
	c=b;
	b=a;
	a=c;
}
/*	
	if(c<a && c<b)
	{
		swap=a;
		a=c;
		c=a;
		swap=b;
		b=c;
		c=swap;
	}
	else
		if(c>a && c<b)
		{
			swap=b;
			b=c;
			c=swap;
		}
		else continue

		
	
	
	
	
	
	
	
	
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
*/
