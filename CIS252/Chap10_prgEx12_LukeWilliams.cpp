/*
	Author: Luke Williams
	Date: 21 April 2018
	Description: Chapter 10 program 12: this program reads in a set of positive integers, representing test scores for a class,
				and outputs how many times a particular number appears in the list.
*/

#include<iostream>
#include<fstream>
#include<vector>

using namespace std;

void insertionSort(vector<int>& list, int listLength);	//function prototype for sorting test scores
void scoreCount(vector<int> list, int size);	//function prototype for outputting test scores and the number of times it exists

int main()
{
	int score = 0;
	vector<int> scoreList;	//creates a vector list for the test scores
	int size;
	
	cout << "Please enter test scores (when finished type: -999 followed by ENTER key): ";
	cin >> score;
	while(score != -999)	//a loop to populate the vector list with user input test scores
		{
			scoreList.push_back(score);
			cin >> score;
		}
	cout << endl;
	
	size = static_cast<int>(scoreList.size());	
	insertionSort(scoreList, size);	//call to the sorting function

	scoreCount(scoreList, size);	//call to the output function
		
	return 0;
}

void insertionSort(vector<int>& list, int listLength)			//function for sorting the list
{
	int location;
	int temp;
	
	for(int firstOutOfOrder = 1; firstOutOfOrder <= listLength; firstOutOfOrder++)
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

void scoreCount(vector<int> list, int size)	//function for outputting test scores and counts of repeated scores
{
	int count = 1;
	
	cout << endl << "Test Score:	Count:" << endl;
		
	for(int i = 0; i < size; i++)
	{
		if(list[i] == list[i+1])
			count++;
		else
		{
			cout << list[i] << "		" << count << endl;
			count = 1;
		}
	}
}
