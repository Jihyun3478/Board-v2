package Board.Boardv2.controller;


import Board.Boardv2.domain.Member;
import Board.Boardv2.domain.Post;
import Board.Boardv2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/new")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/addPost";
    }

    @PostMapping("/posts/new")
    public String create(@Valid @ModelAttribute("post") Post post, BindingResult result) {
        if(result.hasErrors()) {
            return "post/addPost";
        }

        Post addPost = new Post();
        Member member = new Member();
        Date date = new Date();
        addPost.setPostTitle(post.getPostTitle());
        addPost.setPostWriter(member.getName());
        addPost.setPostContent(post.getPostContent());
        addPost.setPostDate();
        addPost.setPostTitle(post.getPostTitle());
    }
}
