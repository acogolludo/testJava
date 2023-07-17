package com.inditex.ecommerce.adapter;

import com.inditex.ecommerce.beans.PriceFilter;
import com.inditex.ecommerce.entities.Price;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class PriceFilterConvert {

    private static PriceFilterConvert instance;

    public static PriceFilterConvert getInstance(){
        if (instance == null){
            instance = new PriceFilterConvert();
        }
        return instance;
    }

    public Price convertToPriceEntity(PriceFilter from){
        Price to = null;
        if (from != null){
            to = new Price();
            to.setProductId(from.getProductId());

            to.setStartDate(Timestamp.valueOf(from.getDateApp().toInstant()
                    .atZone(ZoneId.of("UTC"))
                    .toLocalDateTime()));
            to.setEndDate(Timestamp.valueOf(from.getDateApp().toInstant()
                    .atZone(ZoneId.of("UTC"))
                    .toLocalDateTime()));
            to.setBrandId(from.getBrandId());
        }
        return to;
    }
}
