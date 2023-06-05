package Board.Boardv2.controller;

import Board.Boardv2.domain.Member;
import Board.Boardv2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/member")
public class MemberController {

    private final MemberRepository memberRepository;

    // 회원가입
    @GetMapping("/sign-up")
    public String addForm(@ModelAttribute("member") Member member) { return "member/addMember"; }

    @PostMapping("/sign-up")
    public String save(@Valid @ModelAttribute("member")Member member, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "member/addMember";
        }
        memberRepository.saveMember(member);
//        return "redirect:/";
        return "login/loginForm";
    }
}