package com.example.sssss.service;

import com.example.sssss.domain.Member;
import com.example.sssss.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepo;

    public Member getMember(Member member){
        Optional<Member> findMember = memberRepo.findById(member.getId());
        if(findMember.isPresent())
            return findMember.get();
        else return null;
    }
}
