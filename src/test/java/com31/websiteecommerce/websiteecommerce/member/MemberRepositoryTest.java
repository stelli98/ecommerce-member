package com31.websiteecommerce.websiteecommerce.member;

import com31.websiteecommerce.websiteecommerce.member.entity.Member;
import com31.websiteecommerce.websiteecommerce.member.repository.MemberRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @After
    public void tearDown(){
        memberRepository.deleteAll();
    }


    @Test
    public void saveTest(){
        Member memberA=new Member();
        memberA.setName("Stelli");
        memberA.setEmail("stellitan98@gmail.com");
        memberA.setPassword("123456");
        Member save= memberRepository.save(memberA);
        Assert.assertNotNull("Member id A can't be null", memberA.getId());
        Assert.assertTrue("Member name must be Stelli", save.getName().equals("Stelli"));
        Assert.assertTrue("Member id must same with the saved one", memberA.getId() == save.getId());

    }

    @Test
    public void findByIdTest(){
        Member memberA=new Member();
        memberA.setName("Stelli");
        memberA.setEmail("stellitan98@gmail.com");
        memberA.setPassword("123456");
        Member save= memberRepository.save(memberA);
        Optional<Member> find=memberRepository.findById(save.getId());
        Assert.assertTrue("Member name must show Stelli",save.getName().equals(find.get().getName()));
    }

    @Test
    public void findByAllTest(){
        Member memberA=new Member();
        memberA.setName("Stelli");
        memberA.setEmail("stellitan98@gmail.com");
        memberA.setPassword("123456");
        Member saveMemberA= memberRepository.save(memberA);


        Member memberB=new Member();
        memberB.setName("Stella");
        memberB.setEmail("stella@gmail.com");
        memberB.setPassword("abc456");
        Member saveMemberB= memberRepository.save(memberB);

        List<Member> find= memberRepository.findAll();
        Assert.assertTrue("List size must be 2", find.size()==2);
    }

    @Test
    public void deleteTest(){
        Member memberA=new Member();
        memberA.setName("Stelli");
        memberA.setEmail("stellitan98@gmail.com");
        memberA.setPassword("123456");
        Member saveMemberA= memberRepository.save(memberA);

        Member memberB=new Member();
        memberB.setName("Stella");
        memberB.setEmail("stella@gmail.com");
        memberB.setPassword("abc456");
        Member saveMemberB= memberRepository.save(memberB);

        Member memberC=new Member();
        memberC.setName("Steffi");
        memberC.setEmail("steffi@gmail.com");
        memberC.setPassword("def456");
        Member saveMemberC= memberRepository.save(memberC);


        memberRepository.delete(saveMemberB);
        Assert.assertTrue("List size must be 2", memberRepository.findAll().size()==2);
        Assert.assertFalse("List id from stella must be not found",
                memberRepository.findById(saveMemberB.getId()).isPresent());

    }


}
