/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automoto.controller.algorithms;

import com.automoto.model.BikeModel;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the InsertionSort algorithm for sorting a list of
 * BikeModel objects based on their condition (e.g., Best, Good, Fair, Poor) in
 * either ascending or descending order.
 *
 * @author aashutoshdhakal
 */
public class InsertionSort {

    //A temporary list to hold the BikeModel objects during sorting.
    List<BikeModel> bikeSortList;

    /**
     * Constructor to initialize the InsertionSort object.
     */
    public InsertionSort() {
        bikeSortList = new ArrayList<>();
    }

    /**
     * Sorts the given list of BikeModel objects by their condition.
     *
     * @param bikeList the list of BikeModel objects to be sorted.
     * @param isDesc true for descending order, false for ascending order.
     * @return the sorted list of BikeModel objects.
     * @throws IllegalArgumentException if the input list is null or empty.
     */
    public List<BikeModel> sortByCondition(List<BikeModel> bikeList, boolean isDesc) {

        // Clearing the temporary list and add all elements from the input list.
        this.bikeSortList.clear();
        this.bikeSortList.addAll(bikeList);
        if (bikeList == null || bikeList.isEmpty()) {
            throw new IllegalArgumentException("Bike list cannot be null or empty.");
        }

        // Performing insertion sort on the list.
        for (int i = 1; i < bikeSortList.size(); i++) {
            BikeModel currentBike = bikeSortList.get(i);
            int j = i - 1;

            // Compareing currentBike with sorted portion and insert at the right position
            while (j >= 0 && shouldSwap(currentBike.getCondition(), bikeSortList.get(j).getCondition(), isDesc)) {
                bikeSortList.set(j + 1, bikeSortList.get(j)); // Shift element to the right
                j--;
            }
            bikeSortList.set(j + 1, currentBike); // Inserts the value at the correct position
        }

        return bikeSortList;
    }

    /**
     * Determines whether two conditions should be swapped based on the sorting order.
     *
     * @param currentCondition the condition of the current BikeModel.
     * @param extremumCondition the condition of the extremum BikeModel.
     * @param isDesc true for descending order, false for ascending order.
     * @return true if the conditions should be swapped, false otherwise.
     */
    
    private boolean shouldSwap(String currentCondition, String extremumCondition, boolean isDesc) {
        int currentPriority = getConditionPriority(currentCondition);
        int extremumPriority = getConditionPriority(extremumCondition);

        return isDesc ? currentPriority > extremumPriority : currentPriority < extremumPriority;
    }

    /**
     * Assigns a priority value to each condition for sorting purposes.
     *
     * @param condition the condition string (e.g., Best, Good, Fair, Poor).
     * @return the priority value of the condition.
     * @throws IllegalArgumentException if the condition is invalid.
     */
    
    private int getConditionPriority(String condition) {
        switch (condition) {
            case "Best":
                return 4;
            case "Good":
                return 3;
            case "Fair":
                return 2;
            case "Poor":
                return 1;
            default:
                throw new IllegalArgumentException("Invalid condition: " + condition);
        }
    }

}
