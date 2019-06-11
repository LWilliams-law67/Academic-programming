/*
	Author: Luke Williams
	Date: 24 April 2018
	Description: Chapter 11 program 14: 
*/
#include<iostream>
#include<cstdlib>
#include<cmath>
#include<iomanip>
#include<vector>

using namespace std;

void recConverter(int input, int base);

int main()
{
	int num;
	int base;
	
	cout << "Please input a decimal number that you want to be converted to another base: ";
	cin >> num;
	cout << endl;
	
	cout << "Please input a base from 2 to 36 that you want your number converted to: ";
	cin >> base;
	cout << endl;
	
	if(base == 10)
	{
		cout << "A decimal number is base 10 you IDIOT!" << endl;
		return 0;
	}
	else if(num == 0)
	{
		cout << num << " converted to base " << base << " is: " << num << endl;
		return 0;
	}
	
	cout << num << " converted to base " << base << " is: ";
	recConverter(num, base);
	cout << endl;
	
	return 0;
}

void recConverter(int input, int base)
{
	int temp;
	
	if(input != 0)
	{
		temp = input%base;
		input = input/base;
		recConverter(input, base);
		if(temp > 9)
			cout << static_cast<char>((temp-9)+64);
		else
			cout << temp;
	}
}
