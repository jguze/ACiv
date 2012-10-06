#include <SFML/System.hpp>
#include <iostream>

class MyThread : public sf::Thread
{
private :
	//Virtual cause we are overloading an inherited method 
	//(not actually necessary, but good for keeping track)
	virtual void Run() 
	{
		while(1)
		{
			std::cout << "I'm thread 2" << std::endl;
			sf::Sleep(0.5f);
		}
	}
};

int main()
{
	//Just use the stack here why not
	MyThread Thread;
	
	Thread.Launch();
	
	for (int i = 0; i < 10; ++i)
	{
		std::cout << "MAIN THREAD" << std::endl;
		sf::Sleep(1.5f);
		//Proof that threads don't block
	}
	
	Thread.Terminate();
	//Properly terminate thread
	
	return EXIT_SUCCESS;
	//Thread is deleted after going out of scope
}