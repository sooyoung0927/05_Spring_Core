package com.wanted.container.section02;

import com.wanted.container.section02.config.AppConfig;
import com.wanted.container.section02.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /*comment
        *  IoC Container (제어의 역전)
        *  section01 에서는 개발자가 집적 new 키워드를 사용해서 인스턴스를 생성하였다
        *  이렇게 되면, 객체 간 결합도가 높아지게 되며, 유연성이 떨어지고 테스트 및 유지보수가 어렵다는 문제가 발생한다
        *  */

        /*comment
        *  IoC Container == ApplicationContext == Bean Factory
        *  == 객체들을 관리할 수 있는 컨테이너 */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        /* AppConfig.class -> AppConfig의 메타데이터 = 모든 Bean 정보를 넘겨라
        *  AnnotationConfigApplicationContext 는 config 파일을 읽어서 컨테이너를 만듦
        *  그래서 그 컨테이너에 모든 Bean 정보를 담는거고 그게 context 로 들어감
        *  그래서 context.getBean으로 컨테이너에 저장된 빈들 중 쓰고자 하는 것을 꺼내서 사용*/

        // 이게 실행되면 하나의 컨테이너를 만듦
        // 매개변수로 인해서 컨테이너에 빈으로 설정해둔 세 객체가 들어감

        // getBean() : 컨테이너에 등록된 객체를 꺼낸다
        PaymentService paymentService = context.getBean("paymentService", PaymentService.class);
        /* "paymentService" 라는 이름으로 지정해둔 메서드 객체를 가지고 와라 -> 그리고 그걸 paymentService에 담음
        *
        *  PaymentService클래스에 있는 메타데이터를 가지고 와서 paymentService 라는 변수에 저장할건데
        *  이 변수의 타입이 PaymentService 라서 해당 타입으로 저장이 됨
        *  int k 처럼 PaymentService paymentService 를 쓰는건데 원래 getBean은 object 타입으로 반환함
        *  object 타입은 원래 모든, 그 어떤 타입이든 다 받을 수 있는 타입
        *  근데 왜 굳이 바꿔야 하나 ?
        *  (클래스가 타입이다 = 클래스 안에 있는 메서드를 쓸 수 있다)
        *  object 타입으로 하면 PaymentService 객체가 object에 담기게 되는데
        *  그러면 PaymentService 안에 있는 메서드들을 사용할 수 없음
        *  object 클래스에 담긴 메서드만 쓸 수 있게 됨 = processPayment 메서드 호출 불가능함
        *  그래서 타입을 PaymentService로 두고 PaymentService.class 로 메타데이터를 넘겨줘서 해당 메서드를 사용할 수 있게 함
        *  */
        // App 시작 시 전 프로젝트에서 객체들을 조립

        String orderId = "order-001";
        double amount = 15000.0;
        boolean result = paymentService.processPayment(orderId,amount);

        System.out.println("결제 결과 : "+ (result ? "성공" : "실패"));
        System.out.println("======================================");

        // @Bean이 싱글톤 인스턴스인지 확인하는 구문
        PaymentService paymentService2 = context.getBean(PaymentService.class);

        System.out.println("payment == payment2 : "+ (paymentService == paymentService2));
        // true
    }
}
