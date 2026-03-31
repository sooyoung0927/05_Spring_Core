package com.wanted.container.section03;

import com.wanted.container.section03.config.AppConfig;
import com.wanted.container.section03.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("===========싱글톤스코프 테스트===========");
        PaymentService singlePay = context.getBean("singlePay", PaymentService.class);

        String orderId = "order-001";
        double amount = 15000.0;
        boolean result = singlePay.processPayment(orderId,amount);
        System.out.println("singlePay의 마지막 주문 id : "+singlePay.getLastOrderId());

        PaymentService singlePay2 = context.getBean("singlePay", PaymentService.class);
        System.out.println("singlePay2의 마지막 주문 id : "+singlePay2.getLastOrderId());

        System.out.println("======================================");



        System.out.println("=========프로토타입 스코프 테스트==========");
        PaymentService protoPay = context.getBean("protoPay", PaymentService.class);

        String orderId2 = "order-001";
        double amount2 = 15000.0;
        boolean result2 = protoPay.processPayment(orderId2,amount2);
        System.out.println("protoPay의 마지막 주문 id : "+protoPay.getLastOrderId());

        PaymentService protoPay2 = context.getBean("protoPay", PaymentService.class);
        System.out.println("protoPay2의 마지막 주문 id : "+protoPay2.getLastOrderId());


        // 싱글톤은 getBean을 할 때마다 같은 객체를 반환해서 singlePay랑 singlePay2가 같은 값을 반환
        // 프로토타입은 getBean 할 때마다 새로운 객체를 생성해서 protoPay랑 protoPay2랑 서로 다른 값을 반환

        // singlePay2에서는 별도로 값을 입력해주지 않아도 singlePay에 있던 값이 출력
        // protoPay2에서는 별도로 값 입력해주지 않으면 protoPay랑은 별개라서 널 반환

    }
}
