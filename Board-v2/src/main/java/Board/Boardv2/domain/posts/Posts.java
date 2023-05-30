package Board.Boardv2.domain.posts;

import lombok.Data;

@Data
public class Posts {

    private Long postId;
    private String postTitle;
    private String postWriter;
    private String postContent;
    private String postDate;
    private int postHit;

    public Posts() {}

    public Posts(String postTitle, String postWriter, String postContent, String postDate, int postHit) {

        this.postTitle = postTitle;
        this.postWriter = postWriter;
        this.postContent = postContent;
        this.postDate = postDate;
        this.postHit = postHit;
    }
}
