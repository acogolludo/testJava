package com.inditex.ecommerce.constant;

import java.math.BigInteger;

public class Constants {

    public static final String DATE_FORMAT_A = "dd-MM-yyyy HH:mm:ss";
    public static final String DATE_FORMAT_B = "yyyy-MM-dd HH:mm:ss";

    public static final String TIMEZONE_UTC = "UTC";

    public enum BrandEnum {
        ZARA(BigInteger.ONE),
        BERSHKA(BigInteger.valueOf(2)),
        STRADIVARIUS(BigInteger.valueOf(3)),
        OYSHO(BigInteger.valueOf(4));

        private BigInteger code;

        BrandEnum(BigInteger code) {
            this.code = code;
        }

        public BigInteger getCode() {
            return this.code;
        }

        public Boolean isEqualTo(BigInteger code) {
            return this.code.compareTo(code) == 0;
        }

        public Boolean existCode(BigInteger code){
            for (BrandEnum element : BrandEnum.values()){
                if (element.isEqualTo(code)){
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
    }
}
