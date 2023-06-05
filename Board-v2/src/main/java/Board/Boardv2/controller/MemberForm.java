package Board.Boardv2.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {
    @NotEmpty(message = "이메일을 입력해주세요.")
//    @Pattern(regexp = "[.@]{3,12}$", message = "3-12자로 입력해주세요")
    private String loginEmail;

    @NotEmpty(message = "비밀번호을 입력해주세요.")
//    @Pattern(regexp = "^{8,12}$", message = "8-12자로 입력해주세요")
    private String loginPw;

    @NotEmpty(message = "닉네임을 입력해주세요.")
    private String name;
}
