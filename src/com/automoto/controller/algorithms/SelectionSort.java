/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automoto.controller.algorithms;

import com.automoto.model.BikeModel;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a SelectionSort algorithm implementation for sorting 
 * a list of BikeModel objects by their price in either ascending or descending order.
 *
 * @author aashutoshdhakal
 */

public class SelectionSort {

    // This is a temporary list to hold the BikeModel objects during sorting.
    List<BikeModel> bikeSortList;

    /**
     * Constructor to initialize the SelectionSort object.
     */
    public SelectionSort() {
        bikeSortList = new ArrayList<>();
    }
    
    /**
     * Sorts the given list of BikeModel objects by their price.
     *
     * @param bikeList the list of BikeModel objects to be sorted.
     * @param isDesc true for descending order, false for ascending order.
     * @return the sorted list of BikeModel objects.
     * @throws IllegalArgumentException if the input list is null or empty.
     */
    public List<BikeModel> sortByPrice(List<BikeModel> bikeList, boolean isDesc) {
        
        // Clears the temporary list and add all elements from the input list.
        this.bikeSortList.clear();
        this.bikeSortList.addAll(bikeList);
        if (bikeList == null || bikeList.isEmpty()) {
            throw new IllegalArgumentException("Bike list cannot be null or empty.");
        }

        for (int i = 0; i < bikeSortList.size() - 1; i++) {
            // Finding the index of the minimum or maximum element in the remaining list.
            int extremumIndex = findExtremumIndex(bikeSortList, i, isDesc);
            // Swaping the current element with the extremum element.
            if (i != extremumIndex) {
                swap(bikeSortList, i, extremumIndex);
            }
        }

        return bikeSortList;
    }


    /**
     * Finds the index of the smallest or largest price element in the list 
     * starting from the given index.
     *
     * @param bikeSortList the list of BikeModel objects.
     * @param startIndex the index from which to start searching.
     * @param isDesc true to find the maximum price, false to find the minimum price.
     * @return the index of the extremum element (minimum or maximum).
     */
    private int findExtremumIndex(List<BikeModel> bikeSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        // Iterate through the remaining list to find the extremum element.
        for (int j = startIndex + 1; j < bikeSortList.size(); j++) {
            if (shouldSwap(bikeSortList.get(j).getPrice(), bikeSortList.get(extremumIndex).getPrice(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }


    /**
     * Determines whether two prices should be swapped based on the sorting order.
     *
     * @param current the price of the current BikeModel.
     * @param extremum the price of the current extremum BikeModel.
     * @param isDesc true for descending order, false for ascending order.
     * @return true if the prices should be swapped, false otherwise.
     */
    private boolean shouldSwap(double current, double extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    
    /**
     * Swaps two elements in the list.
     *
     * @param bikeSortList the list of BikeModel objects.
     * @param i the index of the first element.
     * @param j the index of the second element.
     */
    private void swap(List<BikeModel> bikeSortList, int i, int j) {
        BikeModel temp = bikeSortList.get(i);
        bikeSortList.set(i, bikeSortList.get(j));
        bikeSortList.set(j, temp);
    }
}
