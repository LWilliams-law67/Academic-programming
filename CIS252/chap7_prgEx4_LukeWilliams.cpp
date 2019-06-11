/*
	Author: Luke Williams
	Date: 26 February 2018
	Description: This program sets the name of a person (first middle last) as well as
				prints and compares names of other members.
*/

#include<iostream>
#include<string>
#include<cstring>

using namespace std;

class personType
{
	string firstname;
	string lastname;
	string middlename;
	string fullname;
	string done = "DONE";
	string names[20][3];
		
	public:
		void initializeNames();
		void print() const;
		void setName();
		void getname();
		void comparefirst();
		void comparelast();
		personType();
		personType(string first, string middle, string last);
};

int main()
{
	cout << "You may enter a maximum of 20 names in this program.\n"
			"When the program restarts it will overwrite the previous data.\n\n";
			
	personType person;
	person.initializeNames();
	person.getname();
	cout << "\n";
	person.print();
	person.comparefirst();
	person.comparelast();

return 0;
}


void personType::print() const
{
	for(int a=0; a<20; a++)
	{
		for(int b=0; b<3; b++)
		{
			if(names[a][b] == " ")
				continue;
			else cout << names[a][b] << " ";
			if (b==2)
				cout << endl;
			else continue;
		}
	}
}

void personType::initializeNames()
{
	for(int a=0; a<2; a++)
	{
		for(int b=0; b<3; b++)
			names [a][b] = " ";
	}
}

void personType::getname()
{
	cout << "At any time you may enter 'DONE' as a name to complete your entries.\n";
	int a=0;
	while(a<20)
	{
		for(int b=0; b<3; b++)
		{
			switch (b)
			{
				case 0:
					cout << "Enter person's first name: ";
					getline(cin, firstname);
						if(firstname == "DONE")
							return;
						else names[a][b]= firstname;
					break;
				case 1:
					cout << "Enter person's middle name: ";
					getline(cin, middlename);
						if(middlename == "DONE")
							return;
						else names[a][b]= middlename;
					break;
				case 2:
					cout << "Enter person's last name: ";
					getline(cin, lastname);
						if(lastname == "DONE")
							return;
						else names[a][b]= lastname;
					break;
				default:
					return;
			}
		}
	a++;	
	}
}


void personType::comparefirst()
{
	string first;
	cout << "Input a first name: ";
	getline(cin, first);
	cout << endl;
	int b=0;
	for(int a=0; a<20; a++)
	{
		if(first == names[a][b])
			cout << "Your input matches " << names[a][b] << " " << names[a][1] << " " << names[a][2] << endl;
		else continue;
	}
}

void personType::comparelast()
{
	string last;
	cout << "Input a last name: ";
	getline(cin, last);
	cout << endl;
	int b=2;
	for(int a=0; a<20; a++)
	{
		if(last == names[a][b])
			cout << "Your input matches " << names[a][0] << " " << names[a][1] << " " << names[a][b] << endl;
		else continue;
	}
}

personType::personType()
{
	firstname = " ";
	middlename = " ";
	lastname = " ";
}

