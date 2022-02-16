package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{

        // Member 클래스는 스프링에 의해 관리되는 빈이 아니다.
        // 그렇기에 @Autowired 어노테이션이 있어도 자동 주입할 대상이 존재하지 않기에 메소드 자체가 호출되지 않는다.
        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("setBean1 = " + member);
        }

        // null 호출
        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println("setBean2 = " + member);
        }

        // Optional.empty 호출
        @Autowired
        public void setNoBean3(Optional<Member> member){
            System.out.println("setBean3 = " + member);
        }
    }
}
