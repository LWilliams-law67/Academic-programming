/*
	Author: Luke Williams
	Date: 3 November 2017
	Description: Chapter 4 programming exercise 9 user inputs two numbers, the program outputs: all odd numbers between input numbers,
				the sum of all even numbers between the input numbers, 1 thru 10 and their squares, the sum of the squares of odd numbers between input numbers,
				and the alphabet capitalized
*/

#include<iostream>
#include<iomanip>
#include<fstream>
#include<string>

using namespace std;

int main()
{
//A.
	int sum, i, firstNum, secondNum;
	char letter;
	
	cout << "Please input two integers \nThey must be in sequential order for example 45 and 200 or 15 and 66 \nthen press ENTER: ";
	cin >> firstNum >> secondNum;
	cout << endl;

//B.
	for(i=firstNum; i<=secondNum; i++)
	{
		if((i%2)!=0)
		cout << i << " ";
		else continue;
	}
	cout << endl;

//C.
	for(i=firstNum; i<=secondNum; i++)
	{	
		if((i%2)==0)	
			sum=sum+i;
		else continue;
	}
	cout << "The sum of even numbers between your numbers is: " << sum << endl;
	
//D.
	for(i=1+1; i<10; i++)
		cout << i << " squared equals " << i*i << endl;

//E.
	sum=0;
	for(i=firstNum; i<secondNum; i++)
	{
		if((i%2)!=0)
			sum=sum+i*i;
		else continue;
	}
	cout << "The sum of the squares of odd numbers between your numbers is: " << sum << endl;
	
//F.
	for(letter = 'A'; letter <= 'Z'; letter++)		
		cout << static_cast<char>(letter) << " ";
	
	
	return 0;
	
}
