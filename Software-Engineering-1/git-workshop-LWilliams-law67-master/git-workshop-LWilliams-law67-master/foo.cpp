#include <iostream>

int main ()
{
	int* foo;

	for (int i = 0; i < 37; ++i)
	{
		foo = new int(i);

		int b = i * 13;
		--b;

		b = b % 7;

		if (i == b)
		{
			std::cout << "WHOA!\n";
		}

		b += i;

		*foo = i * b;

		std::cout << *foo << "\n";

		delete foo;
	}

	return 0;
}