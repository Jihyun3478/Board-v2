package Board.Boardv2.service;

import Board.Boardv2.domain.Member;
import Board.Boardv2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member Login(String loginEmail, String loginPw) {
        return memberRepository.findByLoginEmail(loginEmail)
                .filter(m -> m.getLoginPw().equals(loginPw))
                .orElse(null);
    }
}
