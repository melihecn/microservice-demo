package com.example.inventory_service.service;

import com.example.inventory_service.repository.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepo inventoryRepo;

    public boolean isInStock(String skuCode, Integer quantity) {
        // verilen skuCodea göre quantitysi 0dan çok elemanları bul
        return inventoryRepo.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
