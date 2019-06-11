/*
	Author: Luke Williams
	Date: 4 April 2018
	Description: Chapter 9 Programming Exercise 2. This program compares student answers with an answer key
				using dynamic arrays, and evaluates the student score to a letter grade. Then creates an output
				file that stores the student ID, their test answers, and their letter grade.
*/

#include<iostream>
#include<fstream>
#include<cstring>
#include<string>

using namespace std;

char grade(char key[], char student[], int questions, int points);

int main()
{
	char *key; //declares pointer for answer key
	char *ans; //declares pointer for student answers
	int numQ, points; //creates integers for number of questions and point value per question
	char ID[9] = {}; //creates array for student ID

	ifstream infile; //input file is now referred to as infile
	ofstream outfile; //output file is now referred to as outfile
	
	infile.open("Ch9_Ex2Data.txt");
	outfile.open("Ch9_Ex2grades.txt");

	cout << "Input the total number of test questions: ";
	cin >> numQ;
	cout << endl;
	
	cout << "Input the point value per question: ";
	cin >> points;
	cout << endl;
	
	key = new char[numQ+1];
	ans = new char[numQ+1];
	
	char discard; //creates a variable to recieve the extra spaces or new line characters in the infile
	
	infile.get(key, numQ+1, '\n'); //stores the correct answers into key
	infile.get(discard);
	outfile << key << endl; //prints the correct answers to outfile
	
	while(infile)
	{
		infile.get(ID, 9, ' '); //puts the student ID into an array named ID
		infile.get(discard);
		 
		infile.get(ans, numQ+1, '\n'); //puts the students answers to the test into an array named ans
		infile.get(discard);
		
		outfile << ID << " STUDENT ANSWERS: "; //prints student ID to outfile	
		outfile << ans << " STUDENT GRADE: "; //prints student answers to outfile
		outfile << grade(key, ans, numQ, points) << endl; //prints letter grade to output file
	}
	
		
	infile.close(); //closes input file
	outfile.close(); //closes output file
		
	return 0;
}

char grade(char key[], char student[], int questions, int points) //function for determining a students grade
{
	char grade = ' ';
	double score = 0;
	
	for(int i = 0; i < 20; i++) // using a loop to determine the students score
		{
			if(student[i] == key[i])
				score = score + 2;
			else
				score = score; 
		} //student score increases by 2 for each correct answer

		score = score/(questions*points)*100; //puts the student's score into a percentage
			
		if(score >= 90) //calculates the letter grade for the student
			grade = 'A';
		else if(score >= 80 && score < 90)
				grade = 'B';
			else if(score >= 70 && score < 80)
					grade = 'C';
				else if(score >= 60 && score < 70)
						grade = 'D';
					else grade = 'F';
	
	return grade;
}
