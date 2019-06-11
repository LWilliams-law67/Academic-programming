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
	i=firstNum;
	while(i<=secondNum)
	{
		if((i%2)!=0)
		{
			cout << i << " ";
			i++;
		}
		else
			i++;
	}
	cout << endl;

//C.
	i=firstNum;
	while(i<=secondNum)
	{	
		if((i%2)==0)	
			sum=sum+i;
		else
			sum=sum;
		i++;
	}
	cout << "The sum of even numbers between your numbers is: " << sum << endl;
	
//D.
	i=2;
	while(i<10)
	{
		cout << i << " squared equals " << i*i << endl;
		i++;
	}
	
//E.
	sum=0;
	i=firstNum;
	while(i<secondNum)
	{
		if((i%2)!=0)
		{
			sum=sum+i*i;
			i++;
		}
		else
			i++;
	}
	cout << "The sum of the squares of odd numbers between your numbers is: " << sum << endl;
	
//F.
	letter='A';
	while(letter <= 'Z')		
	{
		cout << static_cast<char>(letter) << " ";
		letter++;
	}
	
	return 0;
	
}
