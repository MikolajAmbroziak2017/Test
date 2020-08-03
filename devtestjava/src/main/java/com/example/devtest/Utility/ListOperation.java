package com.example.devtest.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class ListOperation {
    private ArrayList<Integer> modifiedList;
    private ArrayList<Integer> template;

    public ListOperation(ArrayList args) {
        this.modifiedList = sortList(args);
        this.template = new ArrayList<Integer>();
    }

    //count how many value are different
    public int getDistinct() {
        int counter = 0;
        for (int i = 0; i < modifiedList.size() - 1; i++) {
            if (modifiedList.get(i) == modifiedList.get(i + 1))
                counter++;
        }
        return modifiedList.size() - counter;
    }

    //this function return table with value and complement found
    private int[] findComplement(int value, int toComplement) {
        Optional<Integer> optionalInteger = template.stream().filter(integer -> integer == (toComplement - value)).findFirst();
        if (optionalInteger.isPresent())
            return new int[]{value, optionalInteger.get()};
        return new int[]{value, 0};
    }

    //Creating TASK 2 String
    public String getParsInArray(int toComplement) {
        fillTemplateList();
        StringBuilder sBuilder = new StringBuilder();

        //the length of the loop depends on the number of duplicate values ​​in the table
        //loop go through half the values ​​in the array plus number of duplicate values
        for (int i = 0; i <= (modifiedList.size() / 2) + (modifiedList.size() - getDistinct()); i++) {
            int[] foundedPar = findComplement(modifiedList.get(i), toComplement);

            //validate the data
            if (foundedPar[0] + foundedPar[1] != toComplement || foundedPar[1] < foundedPar[0])
                continue;
            sBuilder.append(foundedPar[0]).append(" ").append(foundedPar[1]).append("\n");
        }
        return sBuilder.toString();
    }

    private void fillTemplateList() {
        for (int i : modifiedList) {
            if (template.stream().filter(integer -> integer == i).findFirst().isPresent())
                continue;
            template.add(i);
        }
    }

    public void showList() {
        StringBuilder sBuilder = new StringBuilder();
        for (int i : modifiedList) {
            sBuilder.append(i).append(" ");
        }
        System.out.println(sBuilder.toString());
    }

    private ArrayList<Integer> sortList(ArrayList<Integer> list) {
        Collections.sort(list);
        return list;
    }

    public void getCount() {
        System.out.println("count: " + modifiedList.size());
    }

    public int getMin() {
        return modifiedList.get(0);
    }

    public int getMax() {
        return modifiedList.get(modifiedList.size() - 1);
    }

    public ArrayList<Integer> getmodifiedList() {
        return modifiedList;
    }

    private void setmodifiedList(ArrayList<Integer> modifiedList) {
        this.modifiedList = modifiedList;
    }

    @Override
    public String toString() {
        return "ListOperation{" +
                "modifiedList=" + modifiedList +
                ", template=" + template +
                '}';
    }
}