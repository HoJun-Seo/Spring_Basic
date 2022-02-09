package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){

        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    // 테스트를 할 때는 성공 뿐만이 아니라 실패 테스트도 반드시 만들어 봐야 한다.
    @Test
    @DisplayName("VIP 가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){

        // given
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(0);
        // 회원등급이 BASIC 인 경우 할인 정책이 적용되지 않기 때문에 discount 가 0 이 되는 것이 정상이다.
    }
}