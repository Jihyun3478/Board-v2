package Board.Boardv2.web.boardV2;


import Board.Boardv2.domain.posts.Posts;
import Board.Boardv2.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/boardV2/posts")
@RequiredArgsConstructor
public class PostsController {

    private final PostsRepository postsRepository;

    @GetMapping
    public String posts(Model model) {
        List<Posts> posts = postsRepository.findAll();
        model.addAttribute("posts", posts);
        return "boardV2/posts";
    }

    @GetMapping("/{postId}")
    public String post(@PathVariable long postId, Model model) {
        Posts post = postsRepository.findById(postId);
        model.addAttribute("post", post);
        return "boardV2/post";
    }

    @GetMapping("/add")
    public String addForm() {
        return "boardV2/addPost";
    }

    @PostMapping("/add")
    public String addPost(Posts posts, RedirectAttributes redirectAttributes) {
        Posts savedPost = postsRepository.save(posts);
        redirectAttributes.addAttribute("postId", savedPost.getPostId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/boardV2/posts/{postId}";
    }

    @GetMapping("/{postId}/edit")
    public String editForm(@PathVariable Long postId, Model model) {
        Posts post = postsRepository.findById(postId);
        model.addAttribute("post", post);
        return "boardV2/editForm";
    }

    @PostMapping("/{postId}/edit")
    public String edit(@PathVariable Long postId, @ModelAttribute Posts post) {
        postsRepository.update(postId, post);
        return "redirect:/boardV2/posts/{postId}";
    }

    @PostConstruct
    public void init() {
        Date date = new Date();
        postsRepository.save(new Posts("title1", "writer1", "content1", date.toString(), 10));
        postsRepository.save(new Posts("title2", "writer2", "content2", date.toString(), 100));
    }
}
