/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automoto.controller.algorithms;

import com.automoto.model.BikeModel;
import java.util.List;

/**
 *
 * @author aashutoshdhakal
 */
public class BinarySearch {
    
    /**
     * Performs a binary search to find a BikeModel object by its model name.
     * The list should be sorted alphabetically by model name for the search to work.
     *
     * @param searchValue the name of the bike model to search for.
     * @param bikeList the list of BikeModel objects, sorted by model name.
     * @param left the starting index of the current search range.
     * @param right the ending index of the current search range.
     * @return the BikeModel object if found, or null if not found.
     */
    
    // This method performs a binary search to find a BikeModel object by its name.
    public BikeModel searchByName(String searchValue, List<BikeModel> bikeList,
            int left, int right) {

        if (right < left) { // If the search range becomes invalid, the value is not in the list.
            return null;
        }

        int mid = (left + right) / 2; // Calculate the middle index of the current search range.

        // Check if the middle element matches the searched value.
        if (searchValue.toLowerCase().equals(bikeList.get(mid).getModel().toLowerCase())) {
            return bikeList.get(mid); // Found the match, return it.
            
            // If the search value is smaller than the middle element, searching the left half.
        } else if (searchValue.compareToIgnoreCase(bikeList.get(mid).getModel()) < 0) {
            return searchByName(searchValue, bikeList, left, mid - 1);
            
        // Otherwise, searching the right half.
        } else {
            return searchByName(searchValue, bikeList, mid + 1, right);
        }

    }
}
