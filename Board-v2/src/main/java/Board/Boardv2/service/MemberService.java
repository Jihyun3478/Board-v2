package Board.Boardv2.service;

import Board.Boardv2.domain.Member;
import Board.Boardv2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /*
     * 회원가입
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicationName(member);
//        validateDuplicationEmail(member);
        memberRepository.saveMember(member);

        return member.getId();
    }

    // 닉네임 중복
    private void validateDuplicationName(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
    }

    // 이메일 중복
//    private void validateDuplicationEmail(Member member) {
//        List<Member> findMembers = memberRepository.findByLoginEmail(member.getLoginEmail());
//        if(!findMembers.isEmpty()) {
//            throw new IllegalStateException("사용 중인 이메일입니다.");
//        }
//    }
}
