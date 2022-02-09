package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        // 회원 객체 생성 후 가입 요청
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 가입이 제대로 됐는지 확인
        Member findMember = memberService.findMember(member.getId());

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
