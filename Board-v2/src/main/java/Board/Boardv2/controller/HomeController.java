package Board.Boardv2.controller;

import Board.Boardv2.domain.Member;
import Board.Boardv2.domain.Post;
import Board.Boardv2.service.PostService;
import Board.Boardv2.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final PostService postService;

    @GetMapping("/")
    public String homeLogin(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {

        List<Post> posts = postService.findItems();
        model.addAttribute("posts", posts);

        // 세션에 회원 데이터가 없으면 home으로
        if(loginMember == null) {
            return "home";
        }

        // 세션이 유지되면 loginHome으로 이동
        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}
