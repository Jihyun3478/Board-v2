package Board.Boardv2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long postId;

    private String postTitle;
    private String postWriter;
    private String postContent;
    private String postDate;
    private int postHit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Post(String postTitle, String postWriter, String postContent, String postDate, int postHit) {
        this.postTitle = postTitle;
        this.postWriter = postWriter;
        this.postContent = postContent;
        this.postDate = postDate;
        this.postHit = postHit;
    }

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getPost().add(this);
    }
}
