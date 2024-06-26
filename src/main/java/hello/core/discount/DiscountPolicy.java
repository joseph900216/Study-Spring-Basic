package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /***
     *
     * @param member
     * @param price
     * @return 할인 대상 금액
     *
     */
    int disconut(Member member, int price);
}
