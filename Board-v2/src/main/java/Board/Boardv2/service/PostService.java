package Board.Boardv2.service;

import Board.Boardv2.domain.Post;
import Board.Boardv2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Transactional
    public void updatePost(Long postId, String title, String content) {
        Post findPost = postRepository.findOne(postId);
        changePost(title, content, findPost);
    }

    private void changePost(String title, String content, Post findPost) {
        findPost.setPostTitle(title);
        findPost.setPostContent(content);
    }

    public List<Post> findItems() {
        return postRepository.findAll();
    }

    public Post findOne(Long postId) {
        return postRepository.findOne(postId);
    }
}
