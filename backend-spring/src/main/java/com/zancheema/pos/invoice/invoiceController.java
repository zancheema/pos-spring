package com.zancheema.pos.invoice;

import com.zancheema.pos.invoice.dto.InvoiceCreationPayload;
import com.zancheema.pos.invoice.dto.InvoiceInfo;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/invoices")
public class invoiceController {
    private final InvoiceService invoiceService;

    public invoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<InvoiceInfo> getInvoices() {
        return invoiceService.getInvoices();
    }

    @PostMapping("/add")
    public ResponseEntity<InvoiceInfo> addInvoice(@RequestBody @Valid InvoiceCreationPayload payload) {
        return ResponseEntity.of(invoiceService.addInvoice(payload));
    }
}
