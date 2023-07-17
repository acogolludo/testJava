package com.inditex.ecommerce.controllers;

import com.inditex.ecommerce.beans.Price;
import com.inditex.ecommerce.beans.PriceFilter;
import com.inditex.ecommerce.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PriceController {


    @Autowired
    private PriceService priceService;

    @RequestMapping(method = RequestMethod.POST, value = "/gettest", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPrice(@RequestBody PriceFilter request) {
        ResponseEntity<Object> resp;
        try {
            Price result = priceService.getActiveProduct(request);
            resp = ResponseEntity.ok(result);
        } catch (Exception ex) {
            ex.printStackTrace();
            resp = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return resp;
    }
}
