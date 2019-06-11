/*
	Author: Luke Williams
	Date: 08 December 2017
	Description: Programmin exercise 1, chapter 6. Extra credit
*/

#include<iostream>
#include<cmath>
#include<iomanip>

using namespace std;

double alpha[50];
void initializeARRAY(double alpha[]);
void fillARRAY(double alpha[]);
void printARRAY(double alpha[]);

int main()
{
	initializeARRAY(alpha);
	fillARRAY(alpha);
	printARRAY(alpha);
	
	return 0;
}

void initializeARRAY(double alpha[])
{
	for(int index=0; index<50; index++)
		alpha[index]=0;
}

void fillARRAY(double alpha[])
{
	for(int index=0; index<25; index++)
		alpha[index] = pow(index, 2);
		
	for(int index=25; index<50; index++)
		alpha[index] = 3*index;
}

void printARRAY(double alpha[])
{
	int size = 1;
	for(int index=0; index<50; index++)
	{
		cout << setw(5) << alpha[index] << " ";
         if ((size % 10) == 0)
           cout << endl;
        size++;
	}
	cout << endl;
}
