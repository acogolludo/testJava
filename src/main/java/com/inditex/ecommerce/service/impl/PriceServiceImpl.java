package com.inditex.ecommerce.service.impl;

import com.inditex.ecommerce.adapter.PriceConvert;
import com.inditex.ecommerce.adapter.PriceFilterConvert;
import com.inditex.ecommerce.beans.Price;
import com.inditex.ecommerce.beans.PriceFilter;
import com.inditex.ecommerce.repository.PriceRepository;
import com.inditex.ecommerce.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceDao;

    public Price getActiveProduct(PriceFilter filter) {
        com.inditex.ecommerce.entities.Price resultEntity = priceDao.getPriceByFilter(PriceFilterConvert.getInstance().convertToPriceEntity(filter));
        if (resultEntity != null) {
            return PriceConvert.getInstance().convertToPrice(resultEntity);
        }
        return null;
    }
}
