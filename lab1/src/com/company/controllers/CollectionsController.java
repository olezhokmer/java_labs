package com.company.controllers;

import com.company.dto.SortCollectionResponse;
import com.company.exceptions.NotPositiveNumberException;
import com.company.services.CollectionsService;
import com.company.util.collections.IntegerComparator;
import com.company.views.View;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsController {
    View view;
    CollectionsService collectionService;

    public CollectionsController() {
        this.view = new View();
        this.collectionService = new CollectionsService();
    }

    public SortCollectionResponse sortCollection() throws NotPositiveNumberException {
        try {
            this.view.enterDividerNumber();
            Integer divider = this.view.readInteger();

            this.view.enterCollectionLength();
            Integer length = this.view.readInteger();

            this.view.enterBoundValue();
            Integer bound = this.view.readInteger();
            SortCollectionResponse response  = this.collectionService.sortCollection(length, divider, bound);

            this.view.outputCollection(response.generatedCollection);
            this.view.outputCollection(response.sortedCollection);

            return response;
        }
        catch (NotPositiveNumberException exception) {
            throw exception;
        }
    }
}
