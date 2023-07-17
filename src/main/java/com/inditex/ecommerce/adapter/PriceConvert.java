package com.inditex.ecommerce.adapter;

import com.inditex.ecommerce.entities.Price;
import org.springframework.format.datetime.DateFormatter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class PriceConvert {

    private static PriceConvert instance;

    public static PriceConvert getInstance() {
        if (instance == null) {
            instance = new PriceConvert();
        }
        return instance;
    }

    public com.inditex.ecommerce.beans.Price convertToPrice(Price from) {
        com.inditex.ecommerce.beans.Price to = null;
        if (from != null) {
            to = new com.inditex.ecommerce.beans.Price();
            to.setPriceId(from.getPriceId());
            to.setBrandId(from.getBrandId());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String dateStr = dateFormat.format(Date.from(from.getStartDate().toInstant()
                    .atZone(ZoneId.of("UTC")).toInstant()));
            to.setStartDate(dateStr);
            dateStr = dateFormat.format(Date.from(from.getEndDate().toInstant()
                    .atZone(ZoneId.of("UTC")).toInstant()));
            to.setEndDate(dateStr);
            to.setPriceList(from.getPriceList());
            to.setProductId(from.getProductId());
            to.setPriority(from.getPriority());
            to.setPrice(from.getPrice());
            to.setCurrency(from.getCurrency());
        }
        return to;
    }
}
