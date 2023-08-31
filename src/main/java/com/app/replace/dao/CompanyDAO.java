package com.app.replace.dao;

import com.app.replace.mapper.CompanyMapper;
import com.app.replace.vo.CompanyVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CompanyDAO {
    private final CompanyMapper companyMapper;

    public Optional<CompanyVO> select(long id){
        return companyMapper.select(id);
    }
    public void update(CompanyVO companyVO){
        companyMapper.update(companyVO);
    }
    public void insert(CompanyVO companyVO){
        companyMapper.insert(companyVO);
    }
}
