package dev.umang.paymentservicejan25.controllers;

import com.razorpay.RazorpayException;
import dev.umang.paymentservicejan25.dtos.GeneratePaymentLinkRequestDTO;
import dev.umang.paymentservicejan25.services.PaymentService;
import dev.umang.paymentservicejan25.services.RazorPayGateWay;
import dev.umang.paymentservicejan25.services.StripeGateWay;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    //dtos and models sometimes look very close but they are independent of each other.
    //models are entities which we store in dbs
    //dtos are just objects which we might receive or send outside from my system
    private RazorPayGateWay razorPayGateWay;
    private StripeGateWay stripeGateWay;
    private int counter = 0;
    public PaymentController(RazorPayGateWay razorPayGateWay, StripeGateWay stripeGateWay){
        this.razorPayGateWay = razorPayGateWay;
        this.stripeGateWay = stripeGateWay;
    }

    //Are we just fetching info already there? or we are creating something??
    @PostMapping("/payments")
    public String generatePaymentLink(@RequestBody GeneratePaymentLinkRequestDTO generatePaymentLinkRequestDTO) throws RazorpayException {
        //Health check, decide which gateway to call
        return razorPayGateWay.generatePaymentLink(generatePaymentLinkRequestDTO.getOrderId());
    }
}
