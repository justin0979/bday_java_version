# bday_java_version
A simple java program of user entering birthday and program outputting day of week that date falls
on and the user's zodiac sign.

To run from linux command line, either do: 

	./run.sh

	(set permissions with: chmod 764 run.sh)

or 

	javac main.java
	java main

This program was a project for a software design class to help students practice making software 
with Agile techniques(the Test-Driven Developement technique was used for this particular program,
via Junit and Maven) and using design patterns.
I've only attached the java code so far and a very rudimentary UML diagram. 
Looking back at the UML, I see that a Template Pattern could be used by having the DayOfWeek and
Zodiac classes extending from an abstract class since both initialize, calculate, and output 
the data with varying methods. As is, this program follows a linear approach of 
MyUser -> DayOfWeek -> Zodiac.

Nothing special to look at, but like stated, the point of this simple project was to gain 
experience properly designing software.
