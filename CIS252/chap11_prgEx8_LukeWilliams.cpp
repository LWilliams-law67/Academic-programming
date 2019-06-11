/*
	Author: Luke Williams
	Date: 24 April 2018
	Description: Chapter 11 program 8: user inputs a multi-digit number and the recursive function
				of this program outputs those digits in reverse order
				EX: input = 123456
					output = 654321
*/

#include<iostream>
#include<cstdlib>
#include<cmath>
#include<iomanip>
#include<vector>

using namespace std;

void reverseDigits(int num, int& reverse);

int main ()
{
	int input;
	int reverse = 0;
	
	cout << "Please enter a multi-digit number: ";
	cin >> input;
	cout << endl;
	
	reverseDigits(input, reverse);
	
	cout << "Reverse order is: " << reverse << endl;
		
	return 0;
}

void reverseDigits(int num, int& reverse)
{
	int digit;
	
	digit = num % 10;
	num = (num - digit) / 10;
	reverse = reverse * 10 + digit;
	
	if(num != 0)
		return reverseDigits(num, reverse);
}
