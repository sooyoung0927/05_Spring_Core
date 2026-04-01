package com.wanted.di.section03.config;

import com.wanted.di.section03.gateway.PaymentInterface;
import com.wanted.di.section03.service.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.wanted.di.section02")

public class AppConfig {

    /*comment
    *  - 지정된 패키지에서 @Component 관련 어노테이션이 붙은 클래스를 스캔하여 빈으로 등록할 수 있게 해준다
    *  - 장점
    *  - 코드 간소화 : @Bean으로 일일이 등록할 필요가 없어진다
    *  - 유연성 : 새로운 컴포넌트 추가 시 설정 변경 없이 자동 인식
    *  - @ComponentScan 시 경로를 작성하지 않으면 자신이 포함될 디렉토리까지를 default로 인식한다
    *  - excludeFilter를 사용하게 되면 사용자 정의의 클래스, 어노테이션, 정규표현식으로 IoC 컨테이너 빈 등록에서 제외할 수 있다.
    *  */

    /*comment
    *  @Qualifier 어노테이션은 특정 Bean을 이름으로 지정한다
    *  @Primary 설정으로 default 값이 kakaopay로 되어 있지만
    *  @Qualifier 어노테이션을 사용하면 명시적으로 Interface에 구현체를 지정할 수 있다
    *  -> 의존성 주입 우선순위는 @Qualifier > @Primary   */

    @Bean("naverPay")
    public PaymentService naverPayment(
            @Qualifier("naverPayGateway") PaymentInterface paymentInterface
            ) {
        return new PaymentService(paymentInterface);
    }
}
