package com.zancheema.pos.stock;

import com.zancheema.pos.item.Item;
import com.zancheema.pos.item.ItemRepository;
import com.zancheema.pos.stock.dto.StockCreationPayload;
import com.zancheema.pos.stock.dto.StockInfo;
import com.zancheema.pos.util.StreamUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final ItemRepository itemRepository;

    public StockServiceImpl(StockRepository stockRepository, ItemRepository itemRepository) {
        this.stockRepository = stockRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public List<StockInfo> getStocks() {
        return StreamUtil.stream(stockRepository.findAll())
                .map(stock -> new StockInfo(stock.getId(), stock.getItem().getName(), stock.getBatchNo(), stock.getQuantity()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StockInfo> addStock(StockCreationPayload payload) {
        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(payload.getItem()));
        if (optionalItem.isEmpty()) {
            return Optional.empty();
        }
        Item item = optionalItem.get();

        Stock stock = new Stock(0L, item, payload.getBatchNo(), payload.getQuantity());
        Stock savedStock = stockRepository.save(stock);
        StockInfo stockInfo = new StockInfo(
                savedStock.getId(),
                savedStock.getItem().getName(),
                savedStock.getBatchNo(),
                savedStock.getQuantity()
        );
        return Optional.of(stockInfo);
    }

    @Override
    public void deleteStock(long id) {
        if (stockRepository.existsById(id)) {
            stockRepository.deleteById(id);
        }
    }
}
