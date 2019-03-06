package com31.websiteecommerce.websiteecommerce.member.service;

import com31.websiteecommerce.websiteecommerce.member.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member create(Member member);
    Optional<Member> findById(Long id);
    List<Member> findAll();
    Optional<Member> update(Member member);
    Member delete(Long id);
}
