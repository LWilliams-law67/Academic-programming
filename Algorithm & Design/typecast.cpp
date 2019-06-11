// This program is the typecast.cpp for project 1 in Algorithm and program design

#include<iostream>
#include<iomanip>

using namespace std;

int main(){
	int cutOffNum = 0;
	float inputNum;
	double truncatedNum, variableNum;
	
	//Question 2-a ask the user to input a number value with three or more digits after the decimal place
	cout << setprecision(15) << "Please input a number with three or more digits after the decimal place: ";
	cin >> inputNum;
	cout << endl;
	
	//Question 2-b variable manipulation to truncate the user input
	variableNum = inputNum * 100;
	cutOffNum = variableNum;
	truncatedNum = static_cast<double>(cutOffNum) / 100.00;
	
	//Question 2-c display the result to the console
	cout << "The truncated result of " << inputNum << " is " << truncatedNum << endl;
	
	return 0;
}
