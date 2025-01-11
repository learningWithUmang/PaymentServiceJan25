package dev.umang.paymentservicejan25.dtos;

public class GeneratePaymentLinkRequestDTO {
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
