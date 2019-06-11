#include <iostream>
using namespace std;

int main() {
	int numRows;
	int numColumns;
	int currentRow;
	int currentColumn;
	char currentColumnLetter;

	cin >> numRows;
	cin >> numColumns;
	//currentColumnLetter = 'A';
	for (currentRow = 1; currentRow <= numRows; currentRow++)
		for (currentColumnLetter = 'A'; currentColumnLetter <= (currentColumnLetter + numColumns); currentColumnLetter++)
			cout << currentRow << currentColumnLetter << " ";/* Your solution goes here  */

	cout << endl;

	return 0;
}