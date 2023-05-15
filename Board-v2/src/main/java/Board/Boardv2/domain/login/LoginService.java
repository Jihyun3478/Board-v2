package Board.Boardv2.domain.login;

import Board.Boardv2.domain.member.Member;
import Board.Boardv2.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /*
     * @return null이면 로그인 실패
     */
    public Member login(String loginID, String loginPW) {
        return memberRepository.findByLoginId(loginID)
                .filter(m -> m.getLoginPW().equals(loginPW))
                .orElse(null);
    }
}
