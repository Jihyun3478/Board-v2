//package Board.Boardv2.domain.post;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
//
//class PostRepositoryTest {
//
//    PostRepository postRepository = new PostRepository();
//    Date date = new Date();
//
//    @AfterEach
//    void afterEach() {
//        postRepository.clearStore();
//    }
//
//    @Test
//    void save() {
//        // given
//        Post post = new Post("title1", "writer1", "content1", date.toString(), 1);
//
//        // when
//        Post savedPost = postRepository.save(post);
//
//        // then
//        Post findPost = postRepository.findById(post.getPostId());
//        assertThat(findPost).isEqualTo(savedPost);
//    }
//
//    @Test
//    void findAll() {
//        // given
//        Post post1 = new Post("title1", "writer1", "content1", date.toString(), 10);
//        Post post2 = new Post("title2", "writer2", "content2", date.toString(), 100);
//        postRepository.save(post1);
//        postRepository.save(post2);
//
//        // when
//        List<Post> result = postRepository.findAll();
//
//        // then
//        assertThat(result.size()).isEqualTo(2);
//        assertThat(result).contains(post1, post2);
//    }
//
//    @Test
//    void updatePost() {
//        // given
//        Post post = new Post("title1", "writer1", "content1", date.toString(), 10);
//
//        Post savedPost = postRepository.save(post);
//        Long postId = savedPost.getPostId();
//
//        // when
//        Post updateParam = new Post("title2", "writer2", "content2", date.toString(), 250);
//        postRepository.update(postId, updateParam);
//
//        // then
//        Post findPost = postRepository.findById(postId);
//
//        assertThat(findPost.getPostTitle()).isEqualTo(updateParam.getPostTitle());
//        assertThat(findPost.getPostWriter()).isEqualTo(updateParam.getPostWriter());
//        assertThat(findPost.getPostContent()).isEqualTo(updateParam.getPostContent());
//        assertThat(findPost.getPostDate()).isEqualTo(updateParam.getPostDate());
//        assertThat(findPost.getPostHit()).isEqualTo(updateParam.getPostHit());
//    }
//}
