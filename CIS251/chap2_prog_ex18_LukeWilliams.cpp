/*
	Author: Luke Williams
	Date: September 29, 2017
	Description: Chapter 2 programming exercise 18 for CIS 251
				Employee salary increase input/output files
*/

#include <iostream>
#include <fstream>
#include <iomanip>
using namespace std;

int main()

{
    ifstream input;
    ofstream output;
    
    string first1, last1, first2, last2, first3, last3, first4, last4, first5, last5;
    double salary1, salary2, salary3, salary4, salary5, raise1, raise2, raise3, raise4, raise5;
    
    input.open("Ch2_Ex18Data.txt");
    output.open("Ch2_Ex18Output.txt");
    
    input >> last1;
    input >> first1;
    input >> salary1;
    input >> raise1;
    
    input >> last2;
    input >> first2;
    input >> salary2;
    input >> raise2;
    
    input >> last3;
    input >> first3;
    input >> salary3;
    input >> raise3;
    
    input >> last4;
    input >> first4;
    input >> salary4;
    input >> raise4;
    
    input >> last5;
    input >> first5;
    input >> salary5;
    input >> raise5;
    
    raise1 = raise1 / 100;
    raise2 = raise2 / 100;
    raise3 = raise3 / 100;
    raise4 = raise4 / 100;
    raise5 = raise5 / 100;
    
    output << fixed << showpoint;
    output << setprecision(2);
    
    output << first1 << " " << last1 << " " << salary1 + (salary1 * raise1) << endl;
    output << first2 << " " << last2 << " " << salary2 + (salary2 * raise2) << endl;
    output << first3 << " " << last3 << " " << salary3 + (salary3 * raise3) << endl;
    output << first4 << " " << last4 << " " << salary4 + (salary4 * raise4) << endl;
    output << first5 << " " << last5 << " " << salary5 + (salary5 * raise5) << endl;
    
    input.close();
    output.close();
    
    return 0;
}
