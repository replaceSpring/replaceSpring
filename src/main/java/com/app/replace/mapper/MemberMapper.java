package com.app.replace.mapper;

import com.app.replace.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public MemberVO select(long id);

    public void update(MemberVO memberVO);
}
