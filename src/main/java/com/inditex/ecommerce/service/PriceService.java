package com.inditex.ecommerce.service;

import com.inditex.ecommerce.beans.Price;
import com.inditex.ecommerce.beans.PriceFilter;
import org.springframework.stereotype.Service;

public interface PriceService {

    Price getActiveProduct(PriceFilter filter);
}
