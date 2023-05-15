package Board.Boardv2.domain.board;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BoardRepository {

    private static final Map<Long, Board> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    public Board save(Board board) {
        board.setId(++sequence);
        store.put(board.getId(), board);
        return board;
    }

    public Board findById(Long id) {
        return store.get(id);
    }

    public List<Board> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long boardId, Board updateParam) {
        Board findBoard = findById(boardId);
        findBoard.setTitle(updateParam.getTitle());
        findBoard.setWriter(updateParam.getWriter());
        findBoard.setContent(updateParam.getContent());
        findBoard.setRegdate(updateParam.getRegdate());
        findBoard.setHit(updateParam.getHit());
    }

    public void clearStore() {
        store.clear();
    }
}
