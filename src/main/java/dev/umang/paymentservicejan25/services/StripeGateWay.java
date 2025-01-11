package dev.umang.paymentservicejan25.services;

import org.springframework.stereotype.Service;

@Service("stripe")
public class StripeGateWay implements PaymentService{
    @Override
    public String generatePaymentLink(Long orderId) {
        return null;
    }
}
