LIBS := -lsfml-window -lsfml-graphics -lsfml-system
CXX := g++ #gcc c++
CXXFLAGS := -g

all: window

%.o: %.cpp	
	$(CXX) $(CXXFLAGS) -c $< -o $@

window: window.o
	$(CXX) $(CXXFLAGS) $< -o $@ $(LIBS)

clean:
	@echo "Removing garbage files (.o and executable)"
	$(RM) window *.o
