package Board.Boardv2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long postId;

    @NotEmpty(message = "제목을 입력해주세요.")
    private String postTitle;

    private String postWriter;

    @NotEmpty(message = "내용을 입력해주세요.")
    private String postContent;

    private String postDate;
    private int postHit;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;
}
