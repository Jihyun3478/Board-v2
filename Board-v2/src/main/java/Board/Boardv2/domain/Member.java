package Board.Boardv2.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "member")
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginID;
    private String loginPW;
    private String name;
    private String email;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();
}
