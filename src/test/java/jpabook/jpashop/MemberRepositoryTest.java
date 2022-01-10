package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Commit
    void 회원을_저장하다() {
        //given
        Member member = new Member();
        member.setUsername("한경수");

        //when
        Long memberId = memberRepository.save(member);
        Member findMember = memberRepository.findById(memberId);

        //then
        assertThat(memberId).isEqualTo(1L);
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
    }

    @Test
    void find() {
    }
}