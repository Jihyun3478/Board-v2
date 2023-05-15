package Board.Boardv2.web;

import Board.Boardv2.domain.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j // 로깅에 대한 추상 레이어를 제공하는 인터페이스의 모임로그 라이브러리
@Controller // 핸들러가 스캔할 수 있는 빈(Bean) 객체가 되어 서블릿용 컨테이너에 생성함
@RequiredArgsConstructor // 'final'이나 '@NotNull'이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션 - 자동 생성자 주입
public class HomeController {

    @GetMapping("/") // GET method 통신
    public String homeLogin(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
        // 세션에 회원 데이터가 없으면 home
        if(loginMember == null) {
            return "home";
        }

        // 세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}