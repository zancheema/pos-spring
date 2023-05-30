package com.zancheema.pos.invoice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceCreationPayload {
    @NotBlank
    @JsonProperty("customer")
    private String customerPhoneNumber;
}
