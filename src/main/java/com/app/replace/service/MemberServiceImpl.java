package com.app.replace.service;

import com.app.replace.dao.MemberDAO;
import com.app.replace.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

    @Override
    public Optional<MemberVO> checkEmail(String memberEmail) {
        return memberDAO.findByMemberEmail(memberEmail);
    }

    @Override
    public void join(MemberVO memberVO) {
        memberDAO.save(memberVO);
    }

    @Override
    public Optional<Long> login(String memberEmail, String memberPassword) {
        return memberDAO.findByMemberEmailAndMemberPassword(memberEmail, memberPassword);
    }

    @Override
    public Optional<MemberVO> getMember(Long id) {
        return memberDAO.findById(id);
    }
}
