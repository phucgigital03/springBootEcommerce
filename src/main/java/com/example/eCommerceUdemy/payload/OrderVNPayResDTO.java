package com.example.eCommerceUdemy.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVNPayResDTO {
    private Long orderId;
    private String email;
    private LocalDate orderDate;
    private Double totalAmount;
    private String orderStatus;
    //  Relationship
    private List<OrderItemDTO> orderItems;
    private PaymentDTO payment;
    private Long addressId;
    private InitPaymentResponse vnPayRes;
}
