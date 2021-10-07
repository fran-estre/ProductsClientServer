package com.company.Shared;

import com.company.Shared.Entities.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Vector;

/**
 *  ProductReader class
 * reads the product from the file .Json
 * @author Francisco Estrella
 * @version 0.1
 */
public class ProductGetter {
    public Vector<Product> read(String data) {
        Vector<Product> products = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            products = objectMapper.readValue(data, new TypeReference<Vector<Product>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return products;
    }
}
