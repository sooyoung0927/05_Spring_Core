package com.wanted.di.section01.config;

import com.wanted.di.section01.service.PaymentService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.wanted.di.section01",
               excludeFilters = @ComponentScan.Filter (
//                       type = FilterType.ASSIGNABLE_TYPE, classes = {PaymentService.class}
                         // 사용자가 지정 특정 클래스 타입을 제외하겠다 -> PaymentService
//                       type = FilterType.ANNOTATION, classes = {org.springframework.stereotype.Service.class}
                         // Service 라는 어노테이션을 제외하겠다
//                       type = FilterType.REGEX, pattern = {"com.wanted.di.section01.service.*"}
                         // service 하위의 모든 것을 제회하겠다
               )
)
//@ComponentScan
// 해당 경로 하위에 있는 모든 클래스들을 수집
// Configuration 어노테이션은 이 클래스파일이 환경설정 파일이라는 것을 나타냄
public class AppConfig {

    /*comment
    *  - 지정된 패키지에서 @Component 관련 어노테이션이 붙은 클래스를 스캔하여 빈으로 등록할 수 있게 해준다
    *  - 장점
    *  - 코드 간소화 : @Bean으로 일일이 등록할 필요가 없어진다
    *  - 유연성 : 새로운 컴포넌트 추가 시 설정 변경 없이 자동 인식
    *  - @ComponentScan 시 경로를 작성하지 않으면 자신이 포함될 디렉토리까지를 default로 인식한다
    *  - excludeFilter를 사용하게 되면 사용자 정의의 클래스, 어노테이션, 정규표현식으로 IoC 컨테이너 빈 등록에서 제외할 수 있다.
    *  */

}
