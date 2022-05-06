package com.company.dto;

import java.util.ArrayList;

public class SortCollectionResponse {
    public ArrayList<Integer> generatedCollection;
    public ArrayList<Integer> sortedCollection;

    public SortCollectionResponse(ArrayList<Integer> generatedCollection, ArrayList<Integer> sortedCollection) {
        this.generatedCollection = generatedCollection;
        this.sortedCollection = sortedCollection;
    }

    public SortCollectionResponse() {

    }
}
