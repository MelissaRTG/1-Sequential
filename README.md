## Steps to run the project in Intellij: 
 
- To get efficient results, use the `-Xint` command in the VM options of the configuration settings.
 
 
1. Open the `1-Sequential` in Intellij.
 
 
2. To run the program, run the `Main.java` in `nl.hva.pa2.algorithm`.
 
 
3. To get different size of datasets, change the filename on`line 17 and 31` of `Main.java` to the filename with the data you wish to run, of which 1T is 100.000 elements, 2T 200.000 elements, etc.
 
 
4. We've already set up the number of threads. If you run the `Main.java` class, the program will run with the amount of threads given in the parameter.
 
 
5. To get the results in the report, run the `Main.java` class 10 times and take the average time of the 10 runs.