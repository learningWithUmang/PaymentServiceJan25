package dev.umang.paymentservicejan25.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service("stripe")
public class StripeGateWay implements PaymentService{
    @Override
    public String generatePaymentLink(Long orderId) throws StripeException {
        Stripe.apiKey = "sk_test_51QRu3gKHqOK4zPOMXPGQDHLDPVt3T4dJmdHP90N6OcQN1HgQlXM3AqMLJ7ALUbtIJlb8QXmVyt3OencLSqTatwss00qan43qcq";
        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("INR")
                        .setUnitAmount(10000L) //100
                        .setRecurring(
                                PriceCreateParams.Recurring.builder()
                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                        .build()
                        )
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Payment for test session on integrating payment gateway").build()
                        )
                        .build();

        Price price = Price.create(priceCreateParams);

        PaymentLinkCreateParams paymentLinkparams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder()
                                .setRedirect(
                                        PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                .setUrl("https://scaler.com")
                                                .build()
                                )
                                .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                .build()
                        )
                        .build();
        PaymentLink paymentLink = PaymentLink.create(paymentLinkparams);
        return paymentLink.toString();
    }
}
