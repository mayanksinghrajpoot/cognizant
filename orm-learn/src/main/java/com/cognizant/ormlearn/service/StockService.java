package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void saveStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Transactional(readOnly = true)
    public List<Stock> getStocksByCodeAndDateRange(String code, Date start, Date end) {
        return stockRepository.findByCodeAndDateBetween(code, start, end);
    }

    @Transactional(readOnly = true)
    public List<Stock> getStocksAbovePrice(String code, BigDecimal closePrice) {
        return stockRepository.findByCodeAndCloseGreaterThan(code, closePrice);
    }

    @Transactional(readOnly = true)
    public List<Stock> getTop3HighestVolumeStocks() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }
}
