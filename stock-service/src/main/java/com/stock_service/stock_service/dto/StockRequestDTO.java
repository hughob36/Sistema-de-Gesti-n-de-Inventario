package com.stock_service.stock_service.dto;

import com.stock_service.stock_service.model.StockStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockRequestDTO {

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, length = 100)
    private String warehouse; // Almacén: "CENTRAL", "WAREHOUSE_A", "WAREHOUSE_B"

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StockStatus status; // AVAILABLE, OUT_OF_STOCK

    /*@Column(name = "last_update")
    private LocalDateTime lastUpdate;*/
}
