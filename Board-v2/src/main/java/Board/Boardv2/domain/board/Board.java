package Board.Boardv2.domain.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private Long id;
    private String title;
    private String writer; // 로그인 ID 연결
    private String content;
    private LocalDateTime regdate;
    private int hit;

    public Board() {
    }

    public Board(String title, String writer, String content, int hit) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.hit = hit;
    }
}
