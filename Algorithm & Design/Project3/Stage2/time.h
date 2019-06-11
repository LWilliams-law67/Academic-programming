/*
 *      File  : time.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The declaration of the class that creates a time for a new transaction
*/
#include<iostream>

class time{
	public:
		time();
		~time();
		void setTime(int h, int m, int s);
		void getTime();
		
	private:
		int hour;
		int minutes;
		int seconds;
};
