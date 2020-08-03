package com.example.devtest;


import com.example.devtest.Utility.GraphCounter;
import com.example.devtest.Utility.ListOperation;
import com.example.devtest.model.InputType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.GenericArrayType;
import java.util.*;


@SpringBootApplication
public class DevtestApplication {

    //Input Value if class input parameters 'args' is empty
    public static String[] args2 = {"1", "2", "10", "7", "5", "3", "6", "6", "13", "0", "14"};
    private static final String taskOneInputPath = "input12.txt";
    private static final String taskThreeInputPath = "input3.txt";
    private static InputType inputType;
    private static ListOperation listOperation;
    private static ArrayList<Integer> inputIntegers;
    private static ArrayList<int[]> inputVertices;
    private static int firstInput;

    public DevtestApplication() {
        this.inputVertices = new ArrayList<int[]>();
        this.firstInput = 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(DevtestApplication.class, args);

        if (fileReader(taskOneInputPath))
            inputType = InputType.FILE;
        else if (args.length == 0)
            inputType = InputType.PARAMETER;
        else
            inputType = InputType.STATIC;

        //selection of input values ​​depending on the type of inputs default from file
        if (inputType == InputType.PARAMETER)
            inputIntegers = getInputList(toArrayParser(args));
        if (inputType == InputType.STATIC)
            inputIntegers = getInputList(toArrayParser(args2));

        //Creating new object of class ListOperations which implements solution of tasks 1 and 2
        listOperation = new ListOperation(inputIntegers);

        //TASK 1
        System.out.println("TASK 1:");
        listOperation.showList();
        listOperation.getCount();
        System.out.println("distinct: " + listOperation.getDistinct());
        System.out.println("min: " + listOperation.getMin());
        System.out.println("max: " + listOperation.getMax() + "\n\n");

        //TASK 2
        System.out.println("TASK 2:");
        System.out.println(listOperation.getParsInArray(13) + "\n\n");

        //TASK 3
        System.out.println("TASK 3:");
        fileReader(taskThreeInputPath);
        //Create a object of class that manages Graph list
        GraphCounter graphCounter = new GraphCounter();
        //loop around all input lines
        for (int[] i : inputVertices) {
            graphCounter.setNewVertices(i);
        }
        //firstVerticleAdd function take first vertices from input file
        // and if is necessary one time overubs graph
        graphCounter.firstVerticleAdd(firstInput);

        //coutGraph() sum every object in graph list
        System.out.println("Graph from input: " + graphCounter.countGraph());

    }

    public static ArrayList<String> toArrayParser(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Arrays.stream(args).forEach(i -> arrayList.add(i));
        return arrayList;
    }

    public static boolean fileReader(String filePath) throws FileNotFoundException {
        {
            //fileReader supports task 1 and 2 input file
            if (filePath == taskOneInputPath) {
                ArrayList<Integer> inputArray = new ArrayList<Integer>();
                try {
                    File file = new File(filePath);
                    Scanner in = new Scanner(file);
                    while (in.hasNext())
                        inputArray.add(in.nextInt());
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
                inputIntegers = inputArray;
            }
            //fileReader supports task 3. input file
            if (filePath == taskThreeInputPath) {
                try {
                    File file = new File(filePath);
                    Scanner in = new Scanner(file);
                    firstInput = in.nextInt();
                    while (in.hasNext()) {
                        int[] template = new int[2];
                        template[0] = in.nextInt();
                        template[1] = in.nextInt();
                        inputVertices.add(template);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            return true;
        }
    }

    //parse String ArrayList to Integer ArrayList
    private static ArrayList<Integer> getInputList(ArrayList<String> args) {
        ArrayList<Integer> inputList = new ArrayList();
        for (String i : args) {
            if (isParsable(i))
                inputList.add(Integer.parseInt(i));
            else
                System.out.println("It's not parsable to Integer data ");
        }
        return inputList;
    }

    private static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}