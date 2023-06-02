package Board.Boardv2.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {
    @NotEmpty(message = "이메일을 입력해주세요.")
    private String loginEmail;

    @NotEmpty(message = "비밀번호을 입력해주세요.")
    private String loginPw;
}
