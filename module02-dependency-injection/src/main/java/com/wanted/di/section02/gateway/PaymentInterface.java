package com.wanted.di.section02.gateway;

public interface PaymentInterface {

    // 걀제 메서드를 추상화
    boolean processPayment(String orderId, double amount);

}
