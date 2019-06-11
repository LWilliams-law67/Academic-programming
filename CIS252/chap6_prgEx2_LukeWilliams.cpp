/*
	Author: Luke Williams
	Date: 29 January  2018
	Description: Programming Excercise 2, the function smallestIndex takes the parameters of an array and its size then returns
				the index of the first occurence of the smallest element in the array.
*/

#include<iostream>
#include<cmath>
#include<iomanip>
#include<cctype>
#include<string>
#include<fstream>

int smallestIndex(int list[], int size);
void initialize(int list[]);
void fill(int list[]);

const int ARRAYSIZE=10;

using namespace std;

int main()
{
	int array[ARRAYSIZE];
	initialize(array);
	
	cout << "Please input integer values for the components of an array." << endl;
	cout << "The array size is " << ARRAYSIZE << " press ENTER after each value" << endl;
	cout << endl;
	
	//fill array
	for(int i=0; i<ARRAYSIZE; i++)
		{
		cout << "array[" << i << "] = ";
		cin >> array[i];
		}

		
	int returnValue=smallestIndex(array, ARRAYSIZE);
	
	cout << "The function has determined that 'array[" << returnValue << "]' is the smallest component of the array." << endl;
	
	return 0;	
}

void initialize(int list[])
{
	for(int i=0; i<ARRAYSIZE; i++)
		list[i]=0;
}

/*void fill(int list[])
{
	for(int index=0; index<ARRAYSIZE; index++)
		if(index%2!=0)
			list[index]=index*-3;
		else
			list[index]=index*4;
}*/

int smallestIndex(int list[], int size)
{
	int index=0;
	for(int i=0; i<ARRAYSIZE; i++)
		{
		if(list[i]<list[index])
			index=i;
		}
	return index;
}
