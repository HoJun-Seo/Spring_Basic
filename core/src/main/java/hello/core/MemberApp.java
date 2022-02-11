package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new AppConfig().memberService();

        // 아래의 코드를 통해 스프링이 AppConfig 클래스에 작성되어 있는 @Bean 어노테이션이 붙어있는 메소드를 실행시켜서
        // 해당 객체 인스턴스 들을 스프링 컨테이너에 스프링 빈으로서 등록시켜 준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 스프링 빈이 등록될 때 이름은 기본적으로 객체를 생성시킨 메소드 이름으로 저장되므로
        // 아래와 같이 메소드 이름을 통해 MermberService 객체를 가져온다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // 회원 객체 생성 후 가입 요청
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 가입이 제대로 됐는지 확인
        Member findMember = memberService.findMember(member.getId());

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
