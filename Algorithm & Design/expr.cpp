// This is the expr program for project one in Algorithm and program design

#include<iostream>

using namespace std;

int main(){
	//Question 1-a & b declares all variables and assign 11 to a, 3 to b, and 100 to c
	int a = 11;
	int b = 3;
	int c = 100;
	bool result = true;
	
	//Question 1-c display the result to the console
	if((a % b != 2) && (c > a * 10)){
		cout << "The result is " << result << endl;
	}
	else{
		result = false;
		cout << "The result is " << result << endl;
	}
	
	return 0;
}
