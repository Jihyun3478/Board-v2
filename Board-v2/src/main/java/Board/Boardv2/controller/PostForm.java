package Board.Boardv2.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class PostForm {
    @NotEmpty(message = "제목을 입력해주세요.")
    private String postTitle;

    private String postWriter;

    @NotEmpty(message = "내용을 입력해주세요.")
    private String postContent;

    private String postDate;
    private int postHit;
}
