package com.inditex.ecommerce.repository.impl;

import com.inditex.ecommerce.entities.Price;
import com.inditex.ecommerce.exceptions.ProductException;
import com.inditex.ecommerce.repository.PriceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PriceDao implements PriceRepository {

    private final String PARAM_BRAND_ID = "brandId";
    private final String PARAM_START_DATE = "startDate";
    private final String PARAM_END_DATE = "endDate";
    private final String PARAM_PRODUCT_ID = "productId";
    @PersistenceContext
    private EntityManager em;

    @Override
    public Price getPriceByFilter(Price filter) throws ProductException {

        Query query = em.createNamedQuery(Price.FIND_BY_PRODUCT_DATE_BRAND);
        query.setParameter(PARAM_BRAND_ID, filter.getBrandId());
        query.setParameter(PARAM_START_DATE, filter.getStartDate());
        query.setParameter(PARAM_END_DATE, filter.getEndDate());
        query.setParameter(PARAM_PRODUCT_ID, filter.getProductId());
        List<Price> lPrice = (List<Price>) query.getResultList();
        if (lPrice != null && !lPrice.isEmpty()) {
            return lPrice.get(0);
        } else {
            if (getPriceByBrandProduct(filter) != null) {
                throw new ProductException("The date is not valid for the product: " + filter.getProductId());
            }
        }
        return null;
    }

    @Override
    public Price getPriceByBrandProduct(Price filter) {

        Query query = em.createNamedQuery(Price.FIND_BY_PRODUCT_BRAND);
        query.setParameter(PARAM_BRAND_ID, filter.getBrandId());
        query.setParameter(PARAM_PRODUCT_ID, filter.getProductId());
        List<Price> lPrice = (List<Price>) query.getResultList();
        if (lPrice != null && !lPrice.isEmpty()) {
            return lPrice.get(0);
        } else {

        }
        return null;
    }
}
