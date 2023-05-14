package Board.Boardv2.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data // @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode 역할 모두 수행
public class Member {
    private Long id;

    @NotEmpty(message = "아이디를 입력해주세요.")
    private String loginID;
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String loginPW;
    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;
    @NotEmpty(message = "이메일을 입력해주세요.")
    private String email;
}
