package com.company.repositories;

import com.company.models.IndustrialProduct;
import com.company.util.DataUtil;

import java.util.Date;

public class IndustrialProductRepository extends Repository<IndustrialProduct> {
    public IndustrialProductRepository() {
        super(new DataUtil().getIndustrialProducts());
    }
}
