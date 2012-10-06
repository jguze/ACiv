#Example makefile for review purposes with sfml
LIBS=-lsfml-system

all:
	@echo "Building code"
	g++ -c "clock.cpp" -o clock.o
	g++ -o clock clock.o $(LIBS)

#Get rid of all the clutter
clean:
	@echo "Removing all object files and executable"
	rm -f clock
	rm -f clock.o
 
#Since we are all on Unix/Linux systems, we could even install the executable on the system
install:
	@echo "Installing game"
	cp clock /usr/bin

uninstall:
	@echo "Uninstalling game"
	rm clock
	rm /usr/bin/clock
