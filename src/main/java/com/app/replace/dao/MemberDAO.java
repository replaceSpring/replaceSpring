package com.app.replace.dao;

import com.app.replace.mapper.MemberMapper;
import com.app.replace.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    public MemberVO select(long id){
        return memberMapper.select(id);
    }
    public void update(MemberVO memberVO){
        memberMapper.update(memberVO);
    }
}
