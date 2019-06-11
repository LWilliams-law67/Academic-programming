/*
	Author: Luke Williams
	Date: 24 April 2018
	Description: Chapter 10 program 13: this program creates a lottery by generating random integers from 1 to 40 (inclusive)
				then allows a user to input guesses. The program then compares the users numbers with the generated numbers 
				to see if the user guessed correctly.
*/

#include<iostream>
#include<cstdlib>
#include<cmath>
#include<iomanip>
#include<ctime>

using namespace std;

void sortLottery(int lot[], int listLength);
bool compare(int lot[], int guess[]);

int main()
{
	int lottery[5] = {0};
	int guess[5] = {0};
	char play = 'y';
	
	while(play == 'y' || play == 'Y')
	{
		for(int i = 0; i < 5; i++)
			lottery[i] = (rand()+time(0)) % 40+1;
		
		sortLottery(lottery, 5);
		 
		cout << "Please enter five numbers from 1 to 40 (inclusive): ";
		for(int i=0; i<5; i++)
			cin >> guess[i];
		cout << endl;
		
		if(compare(lottery, guess)==true)
		{
			cout << "YOU WON! Would you like to play again?";
			cin >> play;
			cout << endl;
		}
		else
		{
			cout << "YOU LOSE! Would you like to play again?";
			cin >> play;
			cout << endl;
		}
	}
	
	return 0;
}

void sortLottery(int lot[], int listLength)	//function for sorting the list
{
	int location;
	int temp;
	
	for(int firstOutOfOrder = 1; firstOutOfOrder <= listLength; firstOutOfOrder++)
		if(lot[firstOutOfOrder] < lot[firstOutOfOrder -1])
		{
			temp = lot[firstOutOfOrder];
			location = firstOutOfOrder;
			
			do
			{
				lot[location] = lot[location-1];
				location--;
			}
			while(location > 0 && lot[location-1] > temp);
				lot[location] = temp;
		}
}

bool compare(int lot[], int guess[])
{
	bool winner[5] = {false, false, false, false, false};
	
	for(int g=0; g<5; g++)
		for(int l=0; l<5; l++)
			if(guess[g] == lot[l])
				winner[g] = true;
			else
				winner[g] = false;
	
	for(int w=0; w<5; w++)
		if(winner[w]==false)
			return false;
	
	return true;
}
