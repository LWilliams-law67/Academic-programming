/*
	Author: Luke Williams
	Date: 6 December 2017
	Description: CIS251 Test 3 Program. This program transforms user inputs of length and width
				into the area and perimeter values using functions
*/

#include<iostream>
#include<cmath>
using namespace std;

double calcArea(double a, double b);
double calcPerim(double c, double d);
const int ENDPROG = 0;

int main()
{
	double l, w;
	
	cout << "Please input length: ";
	cin >> l;
	cout << endl;
	cout << "Please input width: ";
	cin >> w;
	cout << endl;
	
	if(l==0 && w==0)
		return 0;
	
	cout << "\nThe area of the rectangle is " << calcArea(l,w) << " units squared." << endl;
	cout << "The perimeter of the rectangle is " << calcPerim(l,w) << " units." << endl;
	cout << "\nTo EXIT the program ENTER 0 for length and width." << endl;
	
	return main();
}

double calcArea(double a, double b)
{
	double area = a * b;
	return area;
}

double calcPerim(double c, double d)
{
	double perimeter = 2*c+2*d;
	return perimeter;
}

/*
I was not sure if you wanted the functions called outside of the cout statements or not, so here is an alternative main()

int main()
{
	double l, w, area, perimeter;
	
	cout << "Please input length: ";
	cin >> l;
	cout << endl;
	cout << "Please input width: ";
	cin >> w;
	cout << endl;
	
	if(l==0 && w==0)
		return 0;
	
	area = calcArea(l,w);
	perimeter = calcPerim(l,w);
	
	cout << "\nThe area of the rectangle is " << area << " units squared." << endl;
	cout << "The perimeter of the rectangle is " << perimeter << " units." << endl;
	cout << "\nTo EXIT the program ENTER 0 for length and width." << endl;
	
	return main();
}
*/
