package Board.Boardv2.controller;

import Board.Boardv2.service.LoginService;
import Board.Boardv2.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final SessionManager sessionManager;

    @GetMapping("/sign-in")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) { return "login/loginForm"; }
}
