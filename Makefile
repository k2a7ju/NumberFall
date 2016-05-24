#Makefile
ALLSOURCE = ./src/*.java
JAVAC = /usr/bin/javac
JAVA = /usr/bin/java

.PHONY: all
all: comp
comp:
	${JAVAC} -encoding UTF-8 -d ./ ${ALLSOURCE}
test:
	${JAVA} NumberFall

clean:
	rm -r ./*.class