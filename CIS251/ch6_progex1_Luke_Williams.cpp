/*
	Author: Luke Williams
	Date: 10 January 2018
	Description: This program declares and intializes an array of 100 components and prints 10 elements per line
*/

#include<iostream>
#include<cmath>
#include<iomanip>
using namespace std;

double alpha[100];
void  initializeARRAY(double alpha[]);
void  fillARRAY(double alpha[]);
void  printARRAY(double alpha[]);

int main()
{
	initializeARRAY(alpha);
	fillARRAY(alpha);
	printARRAY(alpha);
	
	return 0;
}

void initializeARRAY(double alpha[])
{
	for(int index=0; index<100; index++)
		alpha[index]=0;
}

void fillARRAY(double alpha[])
{
	for(int index = 0; index<50; index++)
		alpha[index] = pow(index, 2);
	for(int index=50; index<100; index++)
		alpha[index] = 3*index;
}

void printARRAY(double alpha[])
{
	int size = 1;
	for(int index=0; index<100; index++)
	{
		cout << setw(5) << alpha[index] << " ";
		if((size%10) == 0)
			cout << endl;
		size++;
	}
	cout << endl;
}
