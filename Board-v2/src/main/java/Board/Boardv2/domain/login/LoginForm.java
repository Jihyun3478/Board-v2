package Board.Boardv2.domain.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {
    @NotEmpty
    private String loginID;
    @NotEmpty
    private String loginPW;
}
