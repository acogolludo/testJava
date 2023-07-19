package com.inditex.ecommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.ecommerce.beans.PriceFilter;
import com.inditex.ecommerce.constant.Constants;
import com.inditex.ecommerce.controllers.PriceController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigInteger;
import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AkkodisTestInditexApplication.class})
class AkkodisTestInditexApplicationNotFoundTests {

    @Autowired
    private PriceController controller;
    private MockMvc mvc;


    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }


    @Test
    public void testBrandNotExist() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT_B);
        PriceFilter filter = new PriceFilter();
        filter.setBrandId(BigInteger.ZERO);
        filter.setProductId(BigInteger.valueOf(35455));
        filter.setDateApp(sdf.parse("2020-06-14 10:00:00"));
        mvc.perform(post("/gettest")
                        .content(stringToJson(filter))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testProductNotExists() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT_B);
        PriceFilter filter = new PriceFilter();
        filter.setBrandId(Constants.BrandEnum.ZARA.getCode());
        filter.setProductId(BigInteger.valueOf(35460));
        filter.setDateApp(sdf.parse("2020-06-14 16:00:00"));
        mvc.perform(post("/gettest")
                        .content(stringToJson(filter))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void testMinorDate() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT_B);
        PriceFilter filter = new PriceFilter();
        filter.setBrandId(Constants.BrandEnum.ZARA.getCode());
        filter.setProductId(BigInteger.valueOf(35455));
        filter.setDateApp(sdf.parse("2019-06-14 21:00:00"));
        mvc.perform(post("/gettest")
                        .content(stringToJson(filter))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMajorDate() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT_B);
        PriceFilter filter = new PriceFilter();
        filter.setBrandId(Constants.BrandEnum.ZARA.getCode());
        filter.setProductId(BigInteger.valueOf(35455));
        filter.setDateApp(sdf.parse("2022-06-15 10:00:00"));
        mvc.perform(post("/gettest")
                        .content(stringToJson(filter))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    private static String stringToJson(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
