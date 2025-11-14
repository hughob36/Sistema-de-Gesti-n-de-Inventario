package com.product_service.product_service.service;

import com.product_service.product_service.dto.ProductRequestDTO;
import com.product_service.product_service.dto.ProductResponseDTO;
import com.product_service.product_service.exception.ResourceNotFoundException;
import com.product_service.product_service.mapper.IProductMapper;
import com.product_service.product_service.model.Product;
import com.product_service.product_service.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final IProductRepository productRepository;
    private final IProductMapper productMapper;

    @Override
    public List<ProductResponseDTO> findAll() {
        return productMapper.toProductResponseDTOList(productRepository.findAll());
    }

    @Override
    public ProductResponseDTO findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found."));
        return productMapper.toProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        Product product = productMapper.toProduct(productRequestDTO);
        return productMapper.toProductResponseDTO(productRepository.save(product));
    }

    @Override
    public void deleteById(Long id) {
        if(!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id not found.");
        }
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponseDTO updateById(Long id, ProductRequestDTO productRequestDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found."));

        productMapper.updateProductFromDto(productRequestDTO,product);
        return productMapper.toProductResponseDTO(productRepository.save(product));
    }
}
