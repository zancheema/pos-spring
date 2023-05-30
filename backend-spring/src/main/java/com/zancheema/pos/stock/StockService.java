package com.zancheema.pos.stock;

import com.zancheema.pos.stock.dto.StockCreationPayload;
import com.zancheema.pos.stock.dto.StockInfo;

import java.util.List;
import java.util.Optional;

public interface StockService {
    List<StockInfo> getStocks();

    Optional<StockInfo> addStock(StockCreationPayload payload);

    void deleteStock(long id);
}
