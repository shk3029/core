package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용")
    void vip_o() {
        // given
        Member vip = new Member(1L, "VIP", Grade.VIP);
        // when
        int discount = discountPolicy.discount(vip, 10000);
        // then
        Assertions.assertEquals(discount, 1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10%할인이 적용안됨")
    void vip_x() {
        Member vipx = new Member(2L, "VIPX", Grade.BASIC);
        int discount = discountPolicy.discount(vipx, 10000);
        Assertions.assertEquals(discount, 0);
    }

}