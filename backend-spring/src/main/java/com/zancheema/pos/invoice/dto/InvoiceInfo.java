package com.zancheema.pos.invoice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zancheema.pos.customer.dto.CustomerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceInfo {
    @JsonProperty("invoice_no")
    private String invoiceNo;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    private CustomerInfo customer;
}
