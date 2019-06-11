/*
	Author: Luke Williams
	Date: 06 November 2017
	Description: Chapter 4 Programming Exercise 13, the user has five tries to guess a random number.
*/

#include<iostream>
#include<cstdlib>
#include<ctime>
#include<iomanip>
#include<fstream>
#include<string>

using namespace std;

int main()
{
	int num, guess;
	bool isGuessed;
	
	num=(rand()+time(0))%100;
	isGuessed=false;
	
	for(int i=1; i<=5; i++)
		{
			cout << "Enter an integer greater than or equal to 0 and less than 100: ";
			cin >> guess;
			cout << endl;
		
			if(guess==num)
			{
				cout << "You Win!" << endl;
				isGuessed = true;
			}
			else if(i==5)
					cout << "You Lose! \nThe number is: " << num << "\nPlay Again!" << endl;
			else if(guess<num)
					cout << "Your guess is lower than the number.\nGuess Again!" << endl;
				else
					cout << "Your guess is higher than the number.\nGuess Again!" << endl;

		}
	
return 0;
}
