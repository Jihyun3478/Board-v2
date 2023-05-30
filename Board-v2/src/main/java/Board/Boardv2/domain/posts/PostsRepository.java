package Board.Boardv2.domain.posts;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostsRepository {

    private static final Map<Long, Posts> store = new HashMap<>();
    private static long sequence = 0L;

    public Posts save(Posts posts) {
        posts.setPostId(++sequence);
        store.put(posts.getPostId(), posts);
        return posts;
    }

    public Posts findById(Long postId) {
        return store.get(postId);
    }

    public List<Posts> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long postId, Posts updateParam) {
        Posts findPost = findById(postId);
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
