Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=INPUTFILE -Darg1=OUTPUTFILE -Darg2=DEBUGVALUE

-----------------------------------------------------------------------

## To create tarball for submission

ant -buildfile src/build.xml tarzip

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.

[Date: 10/19/2017 ]

-----------------------------------------------------------------------

In this assignment I have used State Pattern to implement the security
states of an airport. The airport can be in any of the three states i.e
HIGH_RISK, MODERATE_RISK, LOW_RISK depending on the number of passengers 
and the number of prohibited items each passenger carries. 
The default state is set to LOW_RISK. With each new passenger 
an average is calculated by AverageCalculator class. The purpose of this is 
to avoid calculation by Context class. The AirportRiskContext class handles 
all the States objects and transitions.
The Current State checks if the calculated averages of traffic per day and
prohibited items per day and determines what state the airport should be in.
If the risk is currently low and averages changes to moderate risk, the state
will transition into moderate and similarly for moderate to high and vic-e-versa.

-----------------------------------------------------------------------
