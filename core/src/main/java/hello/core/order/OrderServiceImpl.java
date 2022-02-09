package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // 할인 정책에 대해서는 OrderService 입장에서는 잘 모르니 discountPolicy 에게 일임한다.
        // 이렇게 서로 다른 클래스의 역할에 대해서 서로 모르더라도 기능 수행이 잘 되게끔 하는 것이 설계를 잘한 예시이다.
        // 즉, SOLID 에서 SRP : 단일 책임 원칙을 잘 지킨 것이다.
        // 만약 SRP 원칙이 잘 지켜지지 않았다면, 할인 정책 관련해서 문제가 생겨도 주문 도메인을 같이 고쳐줘야 하는 경우가 생기게 될 것이다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
