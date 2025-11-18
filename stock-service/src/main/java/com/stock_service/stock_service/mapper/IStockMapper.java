package com.stock_service.stock_service.mapper;


import com.stock_service.stock_service.dto.StockRequestDTO;
import com.stock_service.stock_service.dto.StockResponseDTO;
import com.stock_service.stock_service.model.StockRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IStockMapper {

    public List<StockResponseDTO> toStockResponseDTOList(List<StockRecord> stockList);
    public StockResponseDTO toStockResponseDTO(StockRecord stockRecord);
    public StockRecord toStock(StockRequestDTO stockRequestDTO);
    public void updateStockFromDto(StockRequestDTO dto, @MappingTarget StockRecord stockRecord);
}
