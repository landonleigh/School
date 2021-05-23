PRJ_NAME=helloOMP

GCC=g++

OUTPUT=${PRJ_NAME}.exe
SOURCES=${PRJ_NAME}.cpp
CCFLAGS= -fopenmp -g3 -O0

all: ${OUTPUT}
${OUTPUT}:
	${GCC} -o ${OUTPUT} ${CCFLAGS} ${SOURCES}
    
clean:
	rm -f ${OUTPUT}
    
