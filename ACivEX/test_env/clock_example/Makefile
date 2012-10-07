#Example makefile for review purposes with sfml

#State the library used. I think macs work the same way.
LIBS := -lsfml-system

#Choose your compiler
CXX := g++ #gcc c++
CXXFLAGS := -g

#Rules are created so we never compile code if we never changed it
all: clock

clock.o: clock.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@
#$< is $(input) and $@ is $(output)

clock: clock.o
	@echo "Building code"
	$(CXX) $< -o $@ $(LIBS)

#Get rid of all the clutter
clean:
	@echo "Removing all object files and executable"
	$(RM) clock *.o
 
#Since we are all on Unix/Linux systems, we could even install the executable on the system
install:
	@echo "Installing game"
	cp clock /usr/bin

uninstall:
	@echo "Uninstalling game"
	$(RM) /usr/bin/clock
