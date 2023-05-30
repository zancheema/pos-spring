package com.zancheema.pos.invoiceitem;

import com.zancheema.pos.invoiceitem.dto.InvoiceItemCreationPayload;
import com.zancheema.pos.invoiceitem.dto.InvoiceItemInfo;

import java.util.List;
import java.util.Optional;

public interface InvoiceItemService {
    List<InvoiceItemInfo> getInvoiceItems();

    Optional<InvoiceItemInfo> addInvoiceItem(InvoiceItemCreationPayload payload);
}
