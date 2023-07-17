package com.inditex.ecommerce.repository;

import com.inditex.ecommerce.entities.Price;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository {

    Price getPriceByFilter(Price filter);
}
