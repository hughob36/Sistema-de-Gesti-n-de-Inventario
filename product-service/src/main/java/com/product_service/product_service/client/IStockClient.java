package com.product_service.product_service.client;

import com.product_service.product_service.dto.StockResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "stock-service")
public interface IStockClient {

    @GetMapping("/stock")
    public List<StockResponseDTO> findAll();

    @GetMapping("/stock/{productId}")
    public StockResponseDTO findByProductId(@PathVariable Long productId);
}
