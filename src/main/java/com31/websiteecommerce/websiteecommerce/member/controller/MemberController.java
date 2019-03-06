package com31.websiteecommerce.websiteecommerce.member.controller;

import com31.websiteecommerce.websiteecommerce.member.model.Member;
import com31.websiteecommerce.websiteecommerce.member.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Member> findAll(){
        return memberService.findAll();
    }

    @GetMapping(value = "/members/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Member> findById(@PathVariable Long id){
        return memberService.findById(id);
    }

    @PostMapping(value = "/members",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member create(@RequestBody Member member){
        return memberService.create(member);
    }

    @PutMapping(value = "/members",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Optional<Member> update(@RequestBody Member member){
        return memberService.update(member);
    }

    @DeleteMapping(value = "/members/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member delete(@PathVariable Long id){
        return memberService.delete(id);
    }


}
