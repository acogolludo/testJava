package com.inditex.ecommerce.repository;

import com.inditex.ecommerce.entities.Price;
import com.inditex.ecommerce.exceptions.ProductException;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository {

    Price getPriceByFilter(Price filter) throws ProductException;

    Price getPriceByBrandProduct(Price filter);
}
