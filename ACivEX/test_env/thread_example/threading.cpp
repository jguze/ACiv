#include <SFML/System.hpp>
#include <iostream>

class MyInt
{
		int integer;
	public: 
		MyInt(int i);
		int getInt();
};
	
MyInt::MyInt(int i)
{
	integer = i;
}
	
int MyInt::getInt()
{
	return integer;
}

void ThreadFunc(void* UserData)
{
	MyInt* data = static_cast<MyInt*>(UserData);
	while(1)
	{
		std::cout << "I'm thread " << data->getInt() << " looping like this" << std::endl;
		sf::Sleep(0.5f);
	}
}

int main()
{
	MyInt* one = new MyInt(1);
	MyInt* two = new MyInt(2);
	MyInt* three = new MyInt(3);
	MyInt* four = new MyInt(4);
	//Syntax is simple. sf::Thread is of the form <namespace::Object variablename>
	sf::Thread Thread(&ThreadFunc, one); //Pass the function to be threaded and arguments if necessary
	sf::Thread Thread2(&ThreadFunc, two);
	sf::Thread Thread3(&ThreadFunc, three);
	sf::Thread Thread4(&ThreadFunc, four);
	
	Thread.Launch();
	Thread2.Launch();
	Thread3.Launch();
	Thread4.Launch();
	
	for (int i = 0; i < 10; ++i)
	{
		std::cout << "MAIN THREAD" << std::endl;
		sf::Sleep(1.5f);
		//Sleep will prove that the threads are true threads and 
		//do not block each other while looping
	}
	
	delete one;
	delete two;
	delete three;
	delete four;
	
	//Note that Thread.Terminate() is never called. This means the
	//threads will keep running forever even after the main thread
	//runs its course
	
	return EXIT_SUCCESS;
}