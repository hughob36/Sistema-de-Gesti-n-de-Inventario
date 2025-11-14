package com.product_service.product_service.service;


import com.product_service.product_service.model.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll();
    public Product findById(Long id);
    public Product save(Product product);
    public void deleteById(Long id);
    public Product updateById(Long id, Product product);
}
