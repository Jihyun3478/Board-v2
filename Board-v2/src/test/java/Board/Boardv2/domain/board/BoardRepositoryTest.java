package Board.Boardv2.domain.board;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class BoardRepositoryTest {
    BoardRepository boardRepository = new BoardRepository();

    @AfterEach
    void afterEach() {
        boardRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Board board = new Board("title1", "writer1", "content1", 1);

        // when

        // then
    }
}