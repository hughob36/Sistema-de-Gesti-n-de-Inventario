package com.product_service.product_service.service;


import com.product_service.product_service.dto.ProductRequestDTO;
import com.product_service.product_service.dto.ProductResponseDTO;
import com.product_service.product_service.model.Product;

import java.util.List;

public interface IProductService {

    public List<ProductResponseDTO> findAll();
    public ProductResponseDTO findById(Long id);
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO);
    public void deleteById(Long id);
    public ProductResponseDTO updateById(Long id, ProductRequestDTO productRequestDTO);
}
