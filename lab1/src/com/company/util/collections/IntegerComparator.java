package com.company.util.collections;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {
    private Integer divValue;

    public IntegerComparator(Integer divValue) {
        this.divValue = divValue;
    }

    public int compare(Integer first, Integer second) {
        return first - this.divValue;
    }
}
