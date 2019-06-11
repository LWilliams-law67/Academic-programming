/*
	Author: Luke Williams
	Date: 23 April 2018
	Description: Test 3 bonus program
*/

#include<iostream>
#include<vector>
#include<cstdlib>

using namespace std;

void insertionSort(int list[], int listLength);			//function prototype for sorting list

int main()
{
	int List[20];										//creates an integer array of 20 elements
	for(int i = 0; i<20; i++)							//loop for creating random integers to fill the array
		List[i]=rand() % 100;

	for(int i = 0; i<20;i++)							//loop to output the random numbers created
		cout << List[i] << " ";	
	cout << endl;
	
	insertionSort(List, 20);							//call the insertionSort function to sort the numbers in the array
	
	for(int i = 0; i<20;i++)							//loop to output the new sorted array values
		cout << List[i] << " ";
	cout << endl;
	
	return 0;
}

void insertionSort(int list[], int listLength)			//function for sorting the list
{
	int location;
	int temp;
	
	for(int firstOutOfOrder = 1; firstOutOfOrder < listLength; firstOutOfOrder++)
		if(list[firstOutOfOrder] < list[firstOutOfOrder -1])
		{
			temp = list[firstOutOfOrder];
			location = firstOutOfOrder;
			
			do
			{
				list[location] = list[location-1];
				location--;
			}
			while(location > 0 && list[location-1] > temp);
				list[location] = temp;
		}
}
