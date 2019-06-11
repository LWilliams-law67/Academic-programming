/*
	Author: Luke Williams
	Date: 29 January 2018
	Description: programming example text processing- read an input file to count the number of times a particular letter is used, and
				the number of lines in the file; then, output the results into an output file
*/

#include<iostream>
#include<cmath>
#include<string>
#include<iomanip>
#include<cctype>
#include<fstream>

using namespace std;

void initialize(int& lc, int list[]);
void characterCount(char ch, int list[]);
void copyText(ifstream& intext, ofstream& outtext, char& ch, int list[]);
void writeTotal(ofstream& outext, int lc, int list[]);

int main()
{
	int lineCount;
	int letterCount[26];
	char ch;
	ifstream infile;
	ofstream outfile;
	
	infile.open("textin.txt");
	if(!infile)
		{
		cout << " Cannot open the input file." << endl;
		return 1;
		}
	
	outfile.open("textout.txt");
	
	initialize(lineCount, letterCount);
	
	infile.get(ch);
	while(infile)
		{
		copyText(infile, outfile, ch, letterCount);
		lineCount++;
		infile.get(ch);
		}
	
	writeTotal(outfile, lineCount, letterCount);
	
	infile.close();
	outfile.close();
	
	return 0;
}

void initialize(int& lc, int list[])
{
	lc=0;
	for(int j=0; j<26; j++)
		list[j]=0;
}

void characterCount(char ch, int list[])
{
	int index;
	ch=toupper(ch);
	index=static_cast<int>(ch)-static_cast<int>('A');
	if(0<=index && index<26)
		list[index]++;
}

void copyText(ifstream& intext, ofstream& outtext, char& ch, int list[])
{
	while(ch!='\n')
		{
		outtext << ch;
		characterCount(ch, list);
		intext.get(ch);
		}
	outtext << ch;
}

void writeTotal(ofstream& outtext, int lc, int list[])
{
	outtext << endl << endl;
	outtext << "The number of lines = " << lc << endl;
	for(int index=0; index<26; index++)
		outtext << static_cast<char>(index+static_cast<int>('A')) << " count = " << list[index] << endl;
}
