# DEV-TEST
The dev-test is a project of recruitment tasks.
This program consist of three tasks that differ in the level of difficult.

## RUN PROJECT
Main class and runtime in project is DevtestApplication.class
Is three way to transfer input data to program.

1. As .txt file (default) 
In DevtestApplication.class is function fileReader(String filePath). This function process I/O stream from file and save data in memory

2. As parameters at runtime class
While the application is become to start, you can input parameters as String 
(String[] arg)

3. As local variable
You can change value of Array local variable 

## PROJECT STRUCTURE
There are three packages:
    - model
    - utility
    - devtest

In model you have object model of graph ( Graph.class ) and enum InputType

In utility you have two classes which manage data. GraphCounter.class and ListOperation.class

DevtestApplication.class manage inputs, and have a runtime method main().

### Input
Input file for task one and two is in project folder named input12.txt

Input file for task three  is in project folder, It is named input3.txt

## TASKS 
# Task 1: 

The input is a long list of integers. Please write a small app that will output the list of distinct elements sorted in ascending order, plus the basic measurement information that contains the number of elements in the source, number of distinct elements, min and max value.

# Task 2:

Again, the input is a long list of integers. Provide a working code that will find all the pairs (in this integer list) that sum up to 13. Each pair in the output should have first number not greater than the second one and lines should be sorted in an ascending order.

# Task 3:

The first line of input contains a positive number n, next n lines contains pairs of positive integers, where each pair identifies a connection between two vertices in a graph. Please provide a working code that will give us the answer for the following questions: how many separated graphs are in the input.