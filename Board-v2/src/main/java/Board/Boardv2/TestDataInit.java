//package Board.Boardv2;
//
//import Board.Boardv2.domain.Member;
//import Board.Boardv2.domain.Post;
//import Board.Boardv2.repository.PostRepository;
//import Board.Boardv2.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.Date;
//
//@Component
//@RequiredArgsConstructor
//public class TestDataInit {
//
//    private final PostRepository postRepository;
//    private final MemberRepository memberRepository;
//
//    /**
//     * 테스트용 데이터 추가
//     */
//    @PostConstruct
//    public void init() {
//        Date date = new Date();
//        postRepository.save(new Post("title1", "writer1", "content1", date.toString(), 10));
//        postRepository.save(new Post("title2", "writer2", "content2", date.toString(), 100));
//
//        Member member = new Member();
//
//
//        memberRepository.saveMember(member);
//    }
//}