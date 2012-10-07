#include <SFML/Window.hpp>
#include <SFML/System.hpp>

int main(int argc, char** argv)
{
	//Method to keep track of buttons pressed to
	//process later
	bool LeftKeyPressed = false;
	bool RightKeyPressed = false;
	bool UpKeyPressed = false;
	bool DownKeyPressed = false;
	
	//Generic window creation
	//VideoMode is the chosen video mode for the window: 800x600, 32 bits/pixel
	sf::Window Application(sf::VideoMode(800, 600, 32), "TEST WINDOW");
	
	//Reacreate -> Application.Create(<Paramaters from above>)

	//FULLSCREEN with static call for best video mode
	//sf::Window Application(sf::VideoMode::GetMode(0), "TEST WINDOW", sf::Style::Fullscreen);	
	
	//Main Loop
	bool Running = true;
	sf::Event Event;
	
	//Reference to the window's input window
	const sf::Input& Input = Application.GetInput();
	while (Running)
	{
		Application.Display();
		
		//All events are sent to a stack initially. So all the events 
		//in the stack should be processed every frame, or sent to some
		//asynchronous queue to be processed.
		while (Application.GetEvent(Event))
		{
			//Process Event
			if (Event.Type == sf::Event::Closed)
				Running = false;
			
			LeftKeyPressed = Input.IsKeyDown(sf::Key::Left);
			RightKeyPressed = Input.IsKeyDown(sf::Key::Right);
			UpKeyPressed = Input.IsKeyDown(sf::Key::Up);
			DownKeyPressed = Input.IsKeyDown(sf::Key::Down);
			
			//Process keys

			//More commands to process other events		
		}
	}
	
	return EXIT_SUCCESS;
}