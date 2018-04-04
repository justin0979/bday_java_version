#!/bin/bash

javac main.java

if [[ -f main.class ]];then
	java main
	rm *.class
fi
