package com.wanted.container.section04.service;

import com.wanted.container.section04.gateway.PaymentInterface;

public class PaymentService {

    private final PaymentInterface paymentInterface;

    // 생성자 -> 객체 선언 되자마자 실행
    public PaymentService(PaymentInterface paymentInterface) {
        this.paymentInterface = paymentInterface;
        System.out.println("1. Bean이 생성됨 : PaymentService 객체 생성 완료 ! ");
    }

    public void init(){
        System.out.println("2. Bean 초기화 : PaymentService 초기화 완료 ! ");
    }

    //   ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    //  이게 Application에서 실행이 되면 생성과 초기화가 바로 먼저 진행됨


    public boolean processPayment(String orderId, double amount){
        System.out.println("3. 결제 비즈니스 로직 시작! 주문 ID = "+orderId+ "결제 금액 = "+amount);
        boolean result = paymentInterface.processPayment(orderId,amount);

        if(result){
            System.out.println("결제 처리가 성공적으로 마무리 !");
        }else{
            System.out.println("결제 처리 실패 !");
        }

        return result;
    }

    public void destroy(){
        System.out.println("4. Bean 소멸 : PaymentService 소멸 완료 ! ");
    }

}
