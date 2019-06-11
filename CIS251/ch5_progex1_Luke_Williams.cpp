/*
	Author: Luke Williams
	Date: December 4, 2017
	Description: Program will tell user if input is a vowel or not
*/

#include<iostream>
#include<typeinfo>
#include<string>
using namespace std;

char isVOWEL(char input);
const char ENDPROG = 48;

int main()
{
	char input;
	
	cout << "Enter a number to exit the program.\nType a letter then press ENTER: ";
	cin >> input;
	cout << endl;	
	
	if(static_cast<char>(input) == static_cast<char>(ENDPROG))
		{
		cout << "Exiting the program... " << endl;
		return 0;
		}
	else if(input < 65 || input > 122 || input > 90 && input < 97)
		{
		cout << "User Input is invalid." << endl;
		cout << endl;
		return main();
		}

		
	if(isVOWEL(input)==false)
		cout << input << " is not a vowel." << endl;
	else
		cout << input << " is a vowel." << endl;
	cout << endl;
	return main();
}

char isVOWEL(char input)
{
	if(input == static_cast<char>('a') || input == static_cast<char>('A'))
		return true;
	else
		if(input == static_cast<char>('e') || input == static_cast<char>('E'))
			return true;
		else
			if(input == static_cast<char>('i') || input == static_cast<char>('I'))
				return true;
			else
				if(input == static_cast<char>('o') || input == static_cast<char>('O'))
					return true;
				else
					if(input == static_cast<char>('u') || input == static_cast<char>('U'))
						return true;
					else
						return false;
}
