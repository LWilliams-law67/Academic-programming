#include <fstream>
#include "question.hpp"

using std::ifstream;

#ifndef _QUESTIONBANK_H
#define _QUESTIONBANK_H

class QuestionBank {
		vector<Question> questions;	//	A vector of Question class objects that is populated using
									//	the 'LoadQuestions' function
		ifstream questionsFile;	//	An input filestream variable to use in the 'LoadQuestions' function
								//	to pull an answer and a question from the provided file

	public:
		unsigned iterator = 0;	//	unsigned to iterator through vecotr of question objects
		
		QuestionBank();
		QuestionBank(string question);	//	parameterized constructor accepts a filename as a std::string
										//	where the questions to be loaded reside
		void LoadQuestions();	//	A helper function that reads the file to instantiate the questions
								//	one by one, adding them to the questions vector
		Question GetNextQuestion();	//	This function returns a question from the list for use by the Game class

};

#endif