package com.stock_service.stock_service.service;


import com.stock_service.stock_service.dto.StockRequestDTO;
import com.stock_service.stock_service.dto.StockResponseDTO;

import java.util.List;

public interface IStockService {

    public List<StockRequestDTO> findAll();
    public StockRequestDTO findById(Long id);
    public StockResponseDTO save(StockRequestDTO stockRequestDTO);
    public void deleteById(Long id);
    public StockResponseDTO updateById(Long id, StockRequestDTO stockRequestDTO);
}
