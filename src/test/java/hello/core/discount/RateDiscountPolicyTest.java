package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용")
    void vip_o() {
//        given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
//        when
        int discoun = discountPolicy.disconut(member, 100000);
//        then
        assertThat(discoun).isEqualTo(10000);
    }

    @Test
    @DisplayName("VIP X")
    void vip_x() {
//        given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
//        when
        int discoun = discountPolicy.disconut(member, 100000);
//        then
        assertThat(discoun).isEqualTo(0);
    }

}