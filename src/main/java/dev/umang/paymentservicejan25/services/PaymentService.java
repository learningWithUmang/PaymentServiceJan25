package dev.umang.paymentservicejan25.services;

import com.razorpay.RazorpayException;

public interface PaymentService {
    //can have multiple variations / implementations?
    public String generatePaymentLink(Long orderId) throws RazorpayException;
}
