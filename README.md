# bday_java_version
A simple java program of user entering birthday and program outputting day of week that date falls
on and the user's zodiac sign.

To run from linux command line, either do: 

	./run.sh

	(should be done if cloned; but if not, set permissions with: chmod 764 run.sh.
	this simple program compiles, executes and erases the compiled files.)

or 

	javac main.java
	java main

This program was a project for a software design class to help students practice making software 
with Agile techniques(the Test-Driven Developement technique was used for this particular program,
via Junit and Maven) and using design patterns. The program was originally designed and written in
a 2-man team; however, this version has only the code that I've written (I always would completely
write a team program by myself so that I could get the extra practice of the entire process instead 
of only having my 'agreed upon' duty. I always attempted to maximize my learning with school projects
by immediately beginning the project and doing all parts to project completion. The prototype methods
I wrote aided in integrating my parts of the program, since I didn't have to wait for missing parts of data
to process my work. That way, I didn't have to rely solely on Junit tests to see the fully functioning
requirements).
I've only attached the java code so far and a very rudimentary UML diagram. 
Looking back at the UML, I see that a Template Pattern could be used by having the DayOfWeek and
Zodiac classes extending from an abstract class since both initialize, calculate, and output 
the data with varying methods. As is, this program follows a linear approach of 
MyUser -> DayOfWeek -> Zodiac.

Nothing special to look at, but like stated, the point of this simple project was to gain 
experience properly designing software.
