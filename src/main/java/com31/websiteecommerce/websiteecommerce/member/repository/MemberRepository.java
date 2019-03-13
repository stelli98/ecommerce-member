package com31.websiteecommerce.websiteecommerce.member.repository;

import com31.websiteecommerce.websiteecommerce.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member save(Member member);
    List<Member> findAll();
    Optional<Member> findById(Long id);
    void delete(Member member);
}
