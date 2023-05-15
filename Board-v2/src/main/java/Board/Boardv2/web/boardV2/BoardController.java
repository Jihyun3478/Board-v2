package Board.Boardv2.web.boardV2;

import Board.Boardv2.domain.board.Board;
import Board.Boardv2.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/boardV2/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;

    @GetMapping
    public String boards(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "boardV2/boards";
    }

    @GetMapping("/{id}")
    public String board(@PathVariable Long id, Model model) {
        Board board = boardRepository.findById(id);
        model.addAttribute("board", board);
        return "boardV2/board";
    }

    @GetMapping("/add")
    public String addForm() {
        return "boardV2/addForm";
    }

    @PostMapping("/add")
    public String addBoard(Board board, RedirectAttributes redirectAttributes) {
        Board savedBoard = boardRepository.save(board);
        redirectAttributes.addAttribute("id", savedBoard.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/boardV2/boards/{id}";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Board board = boardRepository.findById(id);
        model.addAttribute("board", board);
        return "boardV2/editForm";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute Board board) {
        boardRepository.update(id, board);
        return "redirect:/boardV2/boards/{id}";
    }

    /*
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        boardRepository.save(new Board("제목1", "글쓴이1", "내용1", LocalDateTime.now(), 1));
        boardRepository.save(new Board("제목2", "글쓴이2", "내용2", LocalDateTime.now(), 10));
    }
}
