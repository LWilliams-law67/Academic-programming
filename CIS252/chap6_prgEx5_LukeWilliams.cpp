/*
	Author: Luke Williams
	Date: 29 January 2018
	Description: Chapter 6 programming exercise 5; user inputs a sentence and the program
				saves it into an array then outputs the sentence in capital letters.
*/

#include<iostream>
#include<string>
#include<cctype>

void intialize(char string[]);
void fill(char string[]);
void print(char string[]);

using namespace std;

int main()
{
	char string[21]={' '};
	
	cout << "Please input a sentence with no more than 20 characters: ";
	cin.get(string, 20);

	cout << endl;
	cout << "Your string is: ";	
	for(int i=0; i<21; i++)
		cout << static_cast<char>(toupper(string[i]));
	cout << endl;
	
	return 0;
}
