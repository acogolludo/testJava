package com.inditex.ecommerce.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;


public class Price {

    @JsonProperty("priceId")
    @Getter @Setter
    BigInteger priceId;
    @JsonProperty("brandId")
    @Getter @Setter
    BigInteger brandId;
    @JsonProperty("startDate")
    @Getter @Setter
    String startDate;
    @JsonProperty("endDate")
    @Getter @Setter
    String endDate;
    @JsonProperty("priceList")
    @Getter @Setter
    BigInteger priceList;
    @JsonProperty("productId")
    @Getter @Setter
    BigInteger productId;
    @JsonProperty("priority")
    @Getter @Setter
    BigInteger priority;
    @JsonProperty("price")
    @Getter @Setter
    BigDecimal price;
    @JsonProperty("currency")
    @Getter @Setter
    String currency;
}
