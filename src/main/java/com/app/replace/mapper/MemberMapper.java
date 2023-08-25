package com.app.replace.mapper;

import com.app.replace.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    // 아이디 중복 검사
    public Optional<MemberVO> selectByMemberEmail(String memberEmail);

    // 회원가입
    @Insert("INSERT INTO TBL_MEMBER (MEMBER_EMAIL, MEMBER_PASSWORD, MEMBER_PHONE) " +
            "VALUES (#{memberEmail}, #{memberPassword}, #{memberPhone})")
    public void insert(MemberVO memberVO);

    // 로그인
    @Select("SELECT ID FROM TBL_MEMBER WHERE MEMBER_EMAIL = #{memberEmail} AND MEMBER_PASSWORD = #{memberPassword}")
    public Optional<Long> selectByMemberEmailAndMemberPassword(@Param("memberEmail") String memberEmail, @Param("memberPassword") String memberPassword);

    // 회원 조회
    public Optional<MemberVO> selectById(Long id);
}
