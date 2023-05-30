package com.zancheema.pos.invoice;

import com.zancheema.pos.invoice.dto.InvoiceCreationPayload;
import com.zancheema.pos.invoice.dto.InvoiceInfo;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    List<InvoiceInfo> getInvoices();

    Optional<InvoiceInfo> addInvoice(InvoiceCreationPayload payload);
}
