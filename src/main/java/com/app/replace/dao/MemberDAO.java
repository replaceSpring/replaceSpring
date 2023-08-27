package com.app.replace.dao;

import com.app.replace.mapper.MemberMapper;
import com.app.replace.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
//    //    아이디 중복검사
//    public Optional<MemberVO> findByMemberEmail(String memberEmail){
//        return memberMapper.selectByMemberEmail(memberEmail);
//    }
//
//    //    회원가입
//    public void save(MemberVO memberVO){
//        memberMapper.insert(memberVO);
//    }
//
//    //    로그인
//    public Optional<Long> findByMemberEmailAndMemberPassword(String memberEmail, String memberPassword){
//        return memberMapper.selectByMemberEmailAndMemberPassword(memberEmail, memberPassword);
//    }
//
//    //    회원 조회
//    public Optional<MemberVO> findById(Long id){
//        return memberMapper.selectById(id);
//    }
}
