package com31.websiteecommerce.websiteecommerce.member.service;

import com31.websiteecommerce.websiteecommerce.member.model.Member;
import com31.websiteecommerce.websiteecommerce.member.repository.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MemberServiceImpl implements MemberService{

    private MemberRepository memberRepository;

    @Override
    public Member create(Member member) {
        if(findById(member.getId())==null){
            return  memberRepository.save(member);
        }
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> update(Member member) {
        Optional<Member> updateMember= memberRepository.findById(member.getId());
        if(updateMember.isPresent()){
            BeanUtils.copyProperties(member,updateMember);
            return updateMember;
        }
        return null;
    }

    @Override
    public Member delete(Long id) {
        Optional<Member> member= findById(id);
        if(member.isPresent()){
            memberRepository.delete(member.get());
            return member.get();
        }
        return null;
    }
}
