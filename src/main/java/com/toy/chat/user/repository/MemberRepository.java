package com.toy.chat.user.repository;

import com.toy.chat.user.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByEmail(String email);

    Optional<Member> findByNickname(String nickname);

}
