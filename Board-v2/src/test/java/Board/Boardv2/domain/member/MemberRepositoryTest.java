package Board.Boardv2.domain.member;

import Board.Boardv2.domain.Member;
import Board.Boardv2.repository.MemberRepository;
import Board.Boardv2.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        // given : 전제조건
        Member member = new Member();
        member.setName("이지현");

        // when : 지정하는 동작
        Long saveId = memberService.join(member);

        // then : 지정된 동작으로 인해 발생하는 변경 사항
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("이지현");

        Member member2 = new Member();
        member1.setName("이지현");

        // when
        memberService.join(member1);
        memberService.join(member2); // 예외 발생해야 함

        // then
        fail("예외가 발생해야 한다.");
    }
}
