package Board.Boardv2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty(message = "이메일을 입력해주세요.")
    @Pattern(regexp = "[.@]{3,12}$", message = "3-12자로 입력해주세요")
    private String loginEmail;

    @NotEmpty(message = "비밀번호을 입력해주세요.")
    @Pattern(regexp = "^{8,12}$", message = "8-12자로 입력해주세요")
    private String loginPw;

    private String name;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

//    @Builder
//    public Member(String loginEmail, String loginPw, String name) {
//        this.loginEmail = loginEmail;
//        this.loginPw = loginPw;
//        this.name = name;
//    }

//    protected Member() {}
}
