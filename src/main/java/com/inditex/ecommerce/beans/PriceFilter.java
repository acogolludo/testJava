package com.inditex.ecommerce.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

public class PriceFilter {

    @JsonProperty("productId")
    @Getter @Setter
    BigInteger productId;
    @JsonProperty("brandId")
    @Getter @Setter
    BigInteger brandId;
    @JsonProperty("applicationDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Getter @Setter
    Date dateApp;

}
