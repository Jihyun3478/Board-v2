//package Board.Boardv2.controller;
//
//import Board.Boardv2.domain.Member;
//import Board.Boardv2.service.LoginService;
//import Board.Boardv2.session.SessionConst;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//@Slf4j
//@Controller
//@RequiredArgsConstructor
//public class LoginController {
//
//    private final LoginService loginService;
//
//    @GetMapping("/sign-in")
//    public String loginForm(@ModelAttribute("loginForm") Member member) {
//        return "login/loginForm";
//    }
//
//    @PostMapping("/sign-in")
//    public String login(@Valid @ModelAttribute Member member, BindingResult bindingResult, HttpServletRequest request) {
//        if (bindingResult.hasErrors()) {
//            return "login/loginForm";
//        }
//
//        Member loginMember = loginService.Login(member.getLoginEmail(), member.getLoginPw());
//
//        if (loginMember == null) {
//            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 틀렸습니다.");
//            return "login/loginForm";
//        }
//
//        HttpSession session = request.getSession();
//        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
//
//        return "redirect:/";
//    }
//}
