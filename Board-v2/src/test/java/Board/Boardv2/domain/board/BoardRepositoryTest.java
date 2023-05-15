package Board.Boardv2.domain.board;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        Board savedBoard = boardRepository.save(board);

        // then
        Board findBoard = boardRepository.findById(board.getId());
        assertThat(findBoard).isEqualTo(savedBoard);
    }

    @Test
    void findAll() {
        // given
        Board board1 = new Board("title1", "writer1", "content1", 1);
        Board board2 = new Board("title2", "writer2", "content2", 10);

        boardRepository.save(board1);
        boardRepository.save(board2);

        // when
        List<Board> result = boardRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(board1, board2);
    }

    @Test
    void updateBoard() {
        // given
        Board board = new Board("title1", "writer1", "content1", 1);

        Board savedBoard = boardRepository.save(board);
        Long boardId = savedBoard.getId();

        // when
        Board updateParam = new Board("title2", "writer2", "content2", 10);
        boardRepository.update(boardId, updateParam);

        Board findBoard = boardRepository.findById(boardId);

        // then
        assertThat(findBoard.getTitle()).isEqualTo(updateParam.getTitle());
        assertThat(findBoard.getWriter()).isEqualTo(updateParam.getWriter());
        assertThat(findBoard.getContent()).isEqualTo(updateParam.getContent());
        assertThat(findBoard.getHit()).isEqualTo(updateParam.getHit());
    }
}