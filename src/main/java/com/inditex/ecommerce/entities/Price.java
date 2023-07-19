package com.inditex.ecommerce.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "PRICES")
@NamedQueries({
        @NamedQuery(name = Price.FIND_BY_PRODUCT_DATE_BRAND, query = "select p from Price p where p.brandId = :brandId and p.startDate <= :startDate and p.endDate >= :endDate and p.productId = :productId order by p.priority desc"),
        @NamedQuery(name = Price.FIND_BY_PRODUCT_BRAND, query = "select p from Price p where p.brandId = :brandId and p.productId = :productId order by p.priority desc")
})
@ToString
@EqualsAndHashCode
public class Price implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String FIND_BY_PRODUCT_DATE_BRAND = "Price.FindByProductDateBrand";
    public static final String FIND_BY_PRODUCT_BRAND = "Price.FindByProductBrand";

    @Id
    @GeneratedValue
    @Getter
    @Setter
    BigInteger priceId;
    @Column(name = "BRAND_ID")
    @Getter
    @Setter
    BigInteger brandId;
    @Column(name = "START_DATE")
    @Getter
    @Setter
    Timestamp startDate;
    @Column(name = "END_DATE")
    @Getter
    @Setter
    Timestamp endDate;
    @Column(name = "PRICE_LIST")
    @Getter
    @Setter
    BigInteger priceList;
    @Column(name = "PRODUCT_ID")
    @Getter
    @Setter
    BigInteger productId;
    @Column(name = "PRIORITY")
    @Getter
    @Setter
    BigInteger priority;
    @Column(name = "PRICE")
    @Getter
    @Setter
    BigDecimal price;
    @Column(name = "CURR")
    @Getter
    @Setter
    String currency;


}
