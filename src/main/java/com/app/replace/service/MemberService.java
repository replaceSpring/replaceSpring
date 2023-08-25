package com.app.replace.service;

import com.app.replace.domain.vo.MemberVO;

import java.util.Optional;


public interface MemberService {
    //    아이디 중복검사
    public Optional<MemberVO> checkEmail(String memberEmail);

    //    회원가입
    public void join(MemberVO memberVO);


    //    로그인
    public Optional<Long> login(String memberEmail, String memberPassword);

    //    회원 조회
    public Optional<MemberVO> getMember(Long id);
}
