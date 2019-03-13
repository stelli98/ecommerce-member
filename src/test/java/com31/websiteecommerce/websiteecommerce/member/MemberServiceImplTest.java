package com31.websiteecommerce.websiteecommerce.member;

import com31.websiteecommerce.websiteecommerce.member.entity.Member;
import com31.websiteecommerce.websiteecommerce.member.service.MemberServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class MemberServiceImplTest {


    private MemberServiceImpl memberService;

    @Before
    public void setUp() throws Exception {
        memberService=new MemberServiceImpl();
    }
    @Test
    public void createTest(){
        Member memberA=new Member(Long.valueOf(1),"Stelli","stellitan98@gmail.com","123456");
        memberService.create(memberA);
        Member memberB=new Member(Long.valueOf(1),"Stelli","stellitan98@gmail.com","123456");
        memberService.create(memberB);
        Assert.assertTrue("Array size must be 1", memberService.findAll().size() == 1);
        Assert.assertFalse("Member can't have similar id",
                memberService.findById(memberB.getId())== null);
    }

    @Test
    public void findByIdTest(){
        Member memberA=new Member(Long.valueOf(1),"Stelli","stellitan98@gmail.com","123456");
        memberService.create(memberA);
        Optional<Member> searchMember1= memberService.findById(Long.valueOf(1));
        Optional<Member> searchMember2= memberService.findById(Long.valueOf(13));
        Assert.assertTrue("Must return Stelli Member Details", memberA.equals(searchMember1));
        Assert.assertTrue("Can't find unregistered id",searchMember2==null);
    }

    @Test
    public void findAllTest(){
        Member memberA=new Member(Long.valueOf(1),"Stelli","stellitan98@gmail.com","123456");
        memberService.create(memberA);
        Member memberB=new Member(Long.valueOf(2),"Stelli","stellitan98@gmail.com","123456");
        memberService.create(memberB);
        Assert.assertTrue("Array size must be 2", memberService.findAll().size()==2);

    }

    @Test
    public void updateTest(){
        Member memberA=new Member(Long.valueOf(1),"Stelli","stellitan98@gmail.com","123456");
        memberService.create(memberA);
        Member updateMember1= memberService.update(
                new Member(Long.valueOf(1),"Stella","stella@gmail.com","abc123")
        );
        Member updateMember2= memberService.update(
                new Member(Long.valueOf(12),"Stella","stella@gmail.com","abc123")
        );
        Assert.assertTrue("Member name must change to stella",memberA.getName().equals(updateMember1.getName()));
        Assert.assertTrue("Member email must change to stella@gmail.com",
                           memberA.getEmail().equals(updateMember1.getEmail()));
        Assert.assertTrue("Member password must change to abc123",memberA.getPassword().equals(updateMember1.getPassword()));
        Assert.assertTrue("Must have same id",memberA.getId() == 1);
        Assert.assertTrue("Id must contain in array",updateMember2 == null);
    }

    @Test
    public void deleteTest(){

        Member memberA=new Member(Long.valueOf(1),"Stelli","stellitan98@gmail.com","123456");
        memberService.create(memberA);

        Member memberB=new Member(Long.valueOf(2),"Stella","stella@gmail.com","123456");
        memberService.create(memberB);

        Member memberC=new Member(Long.valueOf(3),"Steffi","steffi@gmail.com","123456");
        memberService.create(memberC);
        memberService.create(memberC);

        Member deleteMember=memberService.delete(Long.valueOf(2));
        Assert.assertTrue("Can't find member with id=2",memberService.findById(deleteMember.getId())==null);
        Assert.assertTrue("Current list size is 2",memberService.findAll().size()==2);
        Assert.assertTrue("Can't delete id if id isn't registered",memberService.delete(Long.valueOf(12))==null);

    }

    
    

}
