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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시물 등록 화면
    @GetMapping("/posts/new")
    public String createForm(Model model) {
        model.addAttribute("form", new PostForm());
        return "post/addPost";
    }


    @PostMapping("/posts/new")
    public String create(@Valid @ModelAttribute("form") PostForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "post/addPost";
        }

        Post post = new Post();
        Member member = new Member();

        post.setPostTitle(form.getPostTitle());
//        post.setPostWriter(member.getName());
        post.setPostWriter(form.getPostWriter());
        post.setPostContent(form.getPostContent());
//        post.setPostDate(String.valueOf(LocalDate.now()));
        post.setPostDate(form.getPostDate());
        post.setPostHit(form.getPostHit());

        postService.savePost(post);
        return "redirect:/";
    }

    // 게시물 상세 화면
//    <a th:href="@{/posts/datail/{postId}(postId=${post.postId})}"></a>
    @GetMapping("/posts/detail/{postId}")
    public String detailForm(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.findOne(postId);
        model.addAttribute("post", post);
        return "post/detailPost";
    }

    // 게시물 수정 화면
    @GetMapping("posts/{postId}/edit")
    public String updatePostForm(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.findOne(postId);

        PostForm form = new PostForm();
        form.setPostTitle(post.getPostTitle());
        form.setPostContent(post.getPostContent());

        model.addAttribute("form", form);
        return "post/editPost";
    }

    @PostMapping("posts/{postId}/edit")
    public String updatePost(@PathVariable Long postId, @ModelAttribute("form") PostForm form) {
        postService.updatePost(postId, form.getPostTitle(),form.getPostContent());
        return "redirect:/posts";
    }
}
