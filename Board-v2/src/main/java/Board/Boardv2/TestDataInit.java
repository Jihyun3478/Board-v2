package Board.Boardv2;

import Board.Boardv2.domain.member.Member;
import Board.Boardv2.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setLoginID("id1");
        member.setLoginPW("password1");
        member.setName("이름1");
        member.setEmail("이메일1");

        memberRepository.save(member);
    }
}