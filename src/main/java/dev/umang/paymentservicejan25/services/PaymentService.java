package dev.umang.paymentservicejan25.services;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {
    //can have multiple variations / implementations?
    public String generatePaymentLink(Long orderId) throws RazorpayException, StripeException;
}
