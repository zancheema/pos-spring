package com.zancheema.pos.invoice;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InvoiceRepository extends CrudRepository<Invoice, UUID> {
}
