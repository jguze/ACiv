LIBS=-lsfml-system
all:
	@echo "Building code and stuffs"
	g++ -c "threading.cpp" -o threading.o
	g++ -c "threadBase.cpp" -o threadBase.o
	g++ -o threading threading.o $(LIBS)
	g++ -o threadBase threadBase.o $(LIBS)

clean:
	@echo "Removing garbage files (.o and executable)"
	rm -f threading
	rm -f threading.o
	rm -f threadBase.o
	rm -f threadBase
