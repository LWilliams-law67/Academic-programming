/*
	Author: Luke Williams
	Date: 9 Feb. 2018
	Description: Test 1 programming portion.
*/

#include <cstdlib> // include STL
#include <iostream>

const int size = 20; 										//move constant variable outside of function main
    
using namespace std;

int main(int argc, char *argv[])
{
	int sortme[size]; 
    for (int j = 0; j < size; j++)
        sortme[j] = rand();
    for(int j=0; j<20; j++)								//loop to output the contents of the array
    	cout << sortme[j] << " ";
    cout << endl;
    
    int largest=sortme[0];											//declares and initializes variables for largest and smallest values
    int smallest=sortme[0];
    
    for(int j=0; j<20; j++)								//loop determines largest and smallest values in the array
    	{
    		if(sortme[j]>largest)
    			largest=sortme[j];
    		else if(sortme[j]<smallest)
    			smallest=sortme[j];
    			else
    				{
    					largest=largest;
    					smallest=smallest;
					}
		}
		
	cout << "The largest value is: " << largest << " and the smallest value is: " << smallest << endl;

system("PAUSE");
return 0;
}

