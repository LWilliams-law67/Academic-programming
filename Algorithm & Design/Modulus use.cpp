#include <iostream>

using namespace std;

int main(){
	enum days {SUN=0,MON,TUE,WED,THU,FRI,SAT};
	string daysofWeek[] = {"Sunday","Monday","Tuesday","Wednesday",
				"Thursday","Friday"};


	days today = MON;
	int daysAhead = 9;
	int futureDay = today + (daysAhead % 7);

	cout << "If today is " << daysofWeek[today] << ", it will be a "
		<< daysofWeek[futureDay] << " " << daysAhead
		<< " days from today." << endl;

	return 0;
}
