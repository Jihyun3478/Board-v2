package Board.Boardv2.domain.posts;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRepository {

    private static final Map<Long, Post> store = new HashMap<>();
    private static long sequence = 0L;

    public Post save(Post post) {
        post.setPostId(++sequence);
        store.put(post.getPostId(), post);
        return post;
    }

    public Post findById(Long postId) {
        return store.get(postId);
    }

    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long postId, Post updateParam) {
        Post findPost = findById(postId);
        findPost.setPostTitle(updateParam.getPostTitle());
        findPost.setPostWriter(updateParam.getPostWriter());
        findPost.setPostContent(updateParam.getPostContent());
        findPost.setPostDate(updateParam.getPostDate());
        findPost.setPostHit(updateParam.getPostHit());
    }

    public void clearStore() {
        store.clear();
    }
}
