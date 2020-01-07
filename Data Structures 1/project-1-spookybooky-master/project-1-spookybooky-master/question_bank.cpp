#include "question_bank.hpp"

QuestionBank::QuestionBank(){}

QuestionBank::QuestionBank(string question){
	questionsFile.open(question.c_str());	//	stores file name from user input into 'ifstream questionsFile'
	LoadQuestions();
}

void QuestionBank::LoadQuestions() {

	string a;	//	std::string to contain answer from file
	string q;	//	std::string to contain question from file

	while (!questionsFile.eof()) {	//	loop to cycle through end of file
		
		questionsFile >> a;	//	pulls answer from file
		questionsFile.ignore();	//	ignores the space between answers and questions in the file
		getline(questionsFile, q);	//	pulls question from file

		//	calls the parameterized constructor and adds the created Question object to the vector
		questions.push_back(Question(q, a));

	}
}

Question QuestionBank::GetNextQuestion() {
	return questions.at(iterator);
}
