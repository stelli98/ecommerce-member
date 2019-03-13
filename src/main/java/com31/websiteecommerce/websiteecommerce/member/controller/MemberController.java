package com31.websiteecommerce.websiteecommerce.member.controller;

import com31.websiteecommerce.websiteecommerce.member.entity.Member;
import com31.websiteecommerce.websiteecommerce.member.model.ApiKey;
import com31.websiteecommerce.websiteecommerce.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @CrossOrigin
    @GetMapping(value = "/members",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Member> findAll(ApiKey apiKey){
        return memberService.findAll();
    }

    @CrossOrigin
    @GetMapping(value = "/members/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Member> findById(@PathVariable Long id,ApiKey apiKey){
        return memberService.findById(id);
    }

    @CrossOrigin
    @PostMapping(value = "/members",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member create(@RequestBody Member member, ApiKey apiKey){
        return memberService.create(member);
    }

    @CrossOrigin
    @PutMapping(value = "/members",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member update(@RequestBody Member member, ApiKey apiKey){
        return memberService.update(member);
    }

    @CrossOrigin
    @DeleteMapping(value = "/members/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member delete(@PathVariable Long id,ApiKey apiKey){
        return memberService.delete(id);
    }


}
