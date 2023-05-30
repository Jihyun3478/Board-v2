package Board.Boardv2.domain.Posts;

import lombok.Data;

import java.util.Date;

@Data
public class Posts {

    private Long postId;
    private String postTitle;
    private String postWriter;
    private String postContent;
    private Date postDate;
    private int postHit;

    public Posts() {}

    public Posts(String postTitle, String postWriter, String postContent, Date postDate, int postHit) {
        this.postTitle = postTitle;
        this.postWriter = postWriter;
        this.postContent = postContent;
        this.postDate = postDate;
        this.postHit = postHit;
    }
}
