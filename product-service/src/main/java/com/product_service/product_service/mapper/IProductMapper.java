package com.product_service.product_service.mapper;

import com.product_service.product_service.dto.ProductRequestDTO;
import com.product_service.product_service.dto.ProductResponseDTO;
import com.product_service.product_service.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    public List<ProductResponseDTO> toProductResponseDTOList(List<Product> productList);
    public ProductResponseDTO toProductResponseDTO(Product product);
    public Product toProduct(ProductRequestDTO productRequestDTO);
    public void updateProductFromDto(ProductRequestDTO dto, @MappingTarget Product product);
}
