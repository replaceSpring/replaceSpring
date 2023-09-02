package com.app.replace.mapper;

import com.app.replace.vo.CompanyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface CompanyMapper {
    public Optional<CompanyVO> select(long id);
    public void update(CompanyVO companyVO);
    public void insert(CompanyVO companyVO);
    public int selectCompanyCount(long id);

}
