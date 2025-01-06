/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automoto.controller.algorithms;

import com.automoto.model.BikeModel;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a MergeSort algorithm implementation for sorting a list
 * of BikeModel objects by their model names. It supports both ascending and 
 * descending order.
 *
 * @author aashutoshdhakal
 */

public class MergeSort {
    
    /**
     * Sorts the given list of BikeModel objects by their model names.
     *
     * @param bikeList the list of BikeModel objects to be sorted.
     * @param isDesc true for descending order, false for ascending order.
     * @return the sorted list of BikeModel objects.
     * @throws IllegalArgumentException if the input list is null or empty.
     */
    
    public List<BikeModel> sortByModel(List<BikeModel> bikeList, boolean isDesc) {
        if (bikeList == null || bikeList.isEmpty()) {
            throw new IllegalArgumentException("Bike list cannot be null or empty.");
        }

        return mergeSort(bikeList, isDesc);
    }
    
    /**
     * Recursively splits the list into smaller sublists and merges them in
     * sorted order.
     *
     * @param bikeList the list of BikeModel objects to be sorted.
     * @param isDesc true for descending order, false for ascending order.
     * @return the sorted list of BikeModel objects.
     */

    private List<BikeModel> mergeSort(List<BikeModel> bikeList, boolean isDesc) {
        if (bikeList.size() <= 1) {
            return bikeList;
        }

        int mid = bikeList.size() / 2;
        List<BikeModel> left = new ArrayList<>(bikeList.subList(0, mid));
        List<BikeModel> right = new ArrayList<>(bikeList.subList(mid, bikeList.size()));

        // Recursively split and merge
        left = mergeSort(left, isDesc);
        right = mergeSort(right, isDesc);

        return merge(left, right, isDesc);
    }
    
    /**
     * Merges two sorted lists into one sorted list based on the specified order.
     *
     * @param left the first sorted list of BikeModel objects.
     * @param right the second sorted list of BikeModel objects.
     * @param isDesc true for descending order, false for ascending order.
     * @return the merged and sorted list of BikeModel objects.
     */

    private List<BikeModel> merge(List<BikeModel> left, List<BikeModel> right, boolean isDesc) {
        List<BikeModel> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge the elements from left and right based on the comparison
        while (i < left.size() && j < right.size()) {
            if (shouldPlaceLeft(left.get(i).getModel(), right.get(j).getModel(), isDesc)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Adding any remaining elements from the left list
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        // Adding any remaining elements from the right list
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }
    
    /**
     * Determines whether the left model should be placed before the right model
     * based on the specified sorting order.
     *
     * @param leftModel the model name of the left BikeModel.
     * @param rightModel the model name of the right BikeModel.
     * @param isDesc true for descending order, false for ascending order.
     * @return true if the left model should come before the right model, false otherwise.
     */

    private boolean shouldPlaceLeft(String leftModel, String rightModel, boolean isDesc) {
        int comparison = leftModel.compareToIgnoreCase(rightModel);
        return isDesc ? comparison > 0 : comparison < 0;
    }
}
