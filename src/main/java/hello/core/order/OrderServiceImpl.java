package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //컴파일시 생성자 코드를 자동 만들어줌
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); -> DIP, OCP issue


//    필드 주입(Anti-pattern) -> 외부에서 변경 불가능한 단점이 크다
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;
//
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;

//    수정자(setter) 주입
//    선택 혹은 변경 가능성이 있는 의존 관계에 사용

//    Interface(추상화)에만 의존 = DIP 충족
//    final(생성자주입 방식에서만) 키워드 사용시 생성자에서만 값 주입 -> 설정되지 않은 오류를 compile에서 인지 가능
//    항상 생성자 주입 위주로 -> 필요시 수정자 주입을 옵션으로 사용 (필드 주입방식x)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    // new OrderServiceImpl(MemberRepository, DiscountPolicy) 와 같은 예시 -> 스프링 컨테이너에서 일어난다.
    //생성자가 1개일때, 생략 가능
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.disconut(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}