
#include <iostream>
using namespace std;

void ComputeChange(int totCents, int& numQuarters, int& numDimes, int& numNickels, int& numPennies ) {
   numQuarters = totCents / 25;
   cout << numQuarters << endl;
   totCents = totCents - (numQuarters * 25);
   numDimes = totCents / 10;
   cout << numDimes << endl;
   totCents = totCents - (numDimes * 10);
   numNickels = totCents / 5;
   cout << numNickels << endl;
   numPennies = totCents - (numNickels * 5);
	cout << numPennies << endl;
}

int main() {
   int userCents;
   int numQuarters = 0;
   int numDimes = 0;
   int numNickels = 0;
   int numPennies = 0;

   cout << "Enter total cents: " << endl;
   cin >> userCents;

   ComputeChange(userCents, numQuarters, numDimes, numNickels, numPennies);

   cout << "Quarters: " << numQuarters << endl;
   cout << "Dimes: " << numDimes << endl;
   cout << "Nickels: " << numNickels << endl;
   cout << "Pennies: " << numPennies << endl;

   return 0;
}

