package Board.Boardv2.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository // 핸들러가 스캔할 수 있는 빈(Bean) 객체가 되어 루트 컨테이너에 생성함
public class MemberRepository {
    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    // 회원 정보 저장
    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    // 아이디별 조회
    public Member findById(Long id) {
        return store.get(id);
    }

    // 로그인 아이디별 조회
    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getLoginID().equals(loginId))
                .findFirst();
    }

    // 전체 조회
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
