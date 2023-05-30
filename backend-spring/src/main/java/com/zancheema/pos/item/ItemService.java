package com.zancheema.pos.item;

import com.zancheema.pos.item.dto.*;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemInfo> getItems();

    List<Sale> getsSales();

    List<MostBoughtItem> getMostBoughtItems();

    Optional<ItemInfo> addItem(ItemCreationPayload payload);

    Optional<ItemInfo> updateItem(ItemPatch patch);

    void deleteItem(String itemCode);
}
