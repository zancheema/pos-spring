package com.zancheema.pos.invoice;

import com.zancheema.pos.customer.Customer;
import com.zancheema.pos.customer.CustomerRepository;
import com.zancheema.pos.customer.dto.CustomerInfo;
import com.zancheema.pos.invoice.dto.InvoiceCreationPayload;
import com.zancheema.pos.invoice.dto.InvoiceInfo;
import com.zancheema.pos.util.StreamUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, CustomerRepository customerRepository) {
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<InvoiceInfo> getInvoices() {
        return StreamUtil.stream(invoiceRepository.findAll())
                .map(invoice -> new InvoiceInfo(
                        invoice.getInvoiceNo().toString(),
                        invoice.getCreatedAt(),
                        new CustomerInfo(
                                invoice.getCustomer().getCustomerCode().toString(),
                                invoice.getCustomer().getPhoneNumber()
                        )
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<InvoiceInfo> addInvoice(InvoiceCreationPayload payload) {
        Optional<Customer> optionalCustomer = customerRepository.findByPhoneNumber(payload.getCustomerPhoneNumber());
        if (optionalCustomer.isEmpty()) {
            return Optional.empty();
        }
        Customer customer = optionalCustomer.get();

        Invoice invoice = new Invoice(null, LocalDateTime.now(), customer);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        InvoiceInfo invoiceInfo = new InvoiceInfo(
                savedInvoice.getInvoiceNo().toString(),
                savedInvoice.getCreatedAt(),
                new CustomerInfo(
                        savedInvoice.getCustomer().getCustomerCode().toString(),
                        savedInvoice.getCustomer().getPhoneNumber())
        );
        return Optional.of(invoiceInfo);
    }
}
