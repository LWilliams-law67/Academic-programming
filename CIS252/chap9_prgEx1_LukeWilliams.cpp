/*
	Author: Luke Williams
	Date: 2 April 2018
	Description: Chapter 9 programming exercise 1; user inputs a sentence and the program
				saves it into a dynamic array then outputs the sentence in capital letters.
*/

#include<iostream>
#include<string>
#include<cctype>
#include<cstring>

using namespace std;
const int MAXchar = 200;

int main()
{
	char *p;
	p = new char[MAXchar + 1];
	
	for(int i=0; i<MAXchar + 1; i++)
		p[i]=' ';
	
	cout << "Please input a sentence with no more than 20 characters: ";
	cin.get(p, MAXchar);

	cout << endl;
	cout << "Your string is: ";	
	for(int i=0; i<MAXchar + 1; i++)
		cout << static_cast<char>(toupper(p[i]));
	cout << endl;
	
	return 0;
}
