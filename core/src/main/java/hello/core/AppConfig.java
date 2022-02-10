package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // 구현체 클래스에서 작성해준 구현체 생성자 클래스를 통해
    // Repository 구현체인 MemoryMemberRepository 객체를 주입해준다.
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    // 생성자를 통해 주문 구현체에 Repository 와 DiscountPolicy 인터페이스의 구현체를 주입한다.
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
