package com.example.sssss.persistence;

import com.example.sssss.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository  extends CrudRepository<Member, String> {

}
