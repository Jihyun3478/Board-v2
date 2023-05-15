package Board.Boardv2.web;

import Board.Boardv2.domain.member.Member;
import Board.Boardv2.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j // 로깅에 대한 추상 레이어를 제공하는 인터페이스의 모임로그 라이브러리
@Controller // 핸들러가 스캔할 수 있는 빈(Bean) 객체가 되어 서블릿용 컨테이너에 생성함
@RequiredArgsConstructor // 'final'이나 '@NotNull'이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션 - 자동 생성자 주입
public class HomeController {

    private final MemberRepository memberRepository;

    // @GetMapping("/") // GET method 통신
    public String home() {
        return "home";
    }

    @GetMapping("/") // GET method 통신
    public String homeLogin(@CookieValue(name = "memberID", required = false) Long memberID, Model model) {
        if(memberID == null) {
            return "home";
        }

        // 로그인
        Member loginMember = memberRepository.findById(memberID);
        if(loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}