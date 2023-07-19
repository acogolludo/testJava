package com.inditex.ecommerce.service;

import com.inditex.ecommerce.beans.Price;
import com.inditex.ecommerce.beans.PriceFilter;

public interface PriceService {

    Price getActiveProduct(PriceFilter filter) throws Exception;
}
