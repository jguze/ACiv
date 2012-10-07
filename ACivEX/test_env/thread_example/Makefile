LIBS := -lsfml-system
CXX := g++ #gcc
CXXFLAGS := -g

all: threading threadBase

%.o: %.cpp	
	$(CXX) $(CXXFLAGS) -c $< -o $@

threading: threading.o
	$(CXX) $(CXXFLAGS) $< -o $@ $(LIBS)

threadBase: threadBase.o
	$(CXX) $(CXXFLAGS) $< -o $@ $(LIBS)

clean:
	@echo "Removing garbage files (.o and executable)"
	$(RM) threading threadBase *.o
