package com.company.services;

import com.company.dto.SortCollectionResponse;
import com.company.exceptions.NotPositiveNumberException;
import com.company.util.collections.IntegerComparator;
import com.company.validators.NumberValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CollectionsService {
    private Random random;
    private NumberValidator numberValidator;
    public CollectionsService() {
        this.numberValidator = new NumberValidator();
        this.random = new Random();
    }

    public SortCollectionResponse sortCollection(Integer length, Integer divValue, Integer bound) throws NotPositiveNumberException {
        try {
            this.numberValidator.validatePositiveNumber(length);
            this.numberValidator.validatePositiveNumber(divValue);
            this.numberValidator.validatePositiveNumber(bound);

            SortCollectionResponse response = new SortCollectionResponse();

            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < length; i++) list.add(i == 0 ? divValue : this.random.nextInt(bound));

            ArrayList<Integer> listForSorting = new ArrayList<Integer>(list);
            response.generatedCollection = list;
            IntegerComparator comparator = new IntegerComparator(divValue);
            Collections.sort(listForSorting, comparator);
            response.sortedCollection = listForSorting;

            return response;
        }
        catch (NotPositiveNumberException exception) {
            throw exception;
        }
    }
}
