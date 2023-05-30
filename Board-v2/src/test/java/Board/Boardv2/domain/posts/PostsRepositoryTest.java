package Board.Boardv2.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PostsRepositoryTest {

    PostsRepository postsRepository = new PostsRepository();
    Date date = new Date();

    @AfterEach
    void afterEach() {
        postsRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Posts post = new Posts("title1", "writer1", "content1", date.toString(), 1);

        // when
        Posts savedPost = postsRepository.save(post);

        // then
        Posts findPost = postsRepository.findById(post.getPostId());
        assertThat(findPost).isEqualTo(savedPost);
    }

    @Test
    void findAll() {
        // given
        Posts post1 = new Posts("title1", "writer1", "content1", date.toString(), 10);
        Posts post2 = new Posts("title2", "writer2", "content2", date.toString(), 100);
        postsRepository.save(post1);
        postsRepository.save(post2);

        // when
        List<Posts> result = postsRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(post1, post2);
    }

    @Test
    void updatePost() {
        // given
        Posts post = new Posts("title1", "writer1", "content1", date.toString(), 10);

        Posts savedPost = postsRepository.save(post);
        Long postId = savedPost.getPostId();

        // when
        Posts updateParam = new Posts("title2", "writer2", "content2", date.toString(), 250);
        postsRepository.update(postId, updateParam);

        // then
        Posts findPost = postsRepository.findById(postId);

        assertThat(findPost.getPostTitle()).isEqualTo(updateParam.getPostTitle());
        assertThat(findPost.getPostWriter()).isEqualTo(updateParam.getPostWriter());
        assertThat(findPost.getPostContent()).isEqualTo(updateParam.getPostContent());
        assertThat(findPost.getPostDate()).isEqualTo(updateParam.getPostDate());
        assertThat(findPost.getPostHit()).isEqualTo(updateParam.getPostHit());
    }
}
