package com.app.replace.mapper;

import com.app.replace.dto.PositionDTO;
import com.app.replace.dto.Search;
import com.app.replace.vo.PositionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PositionMapper {

    public List<PositionDTO> selectAll();

//    게시글 조회(메인페이지에서 상세보기 페이지로 이동)
    public PositionDTO select(Long id);

    public List<PositionDTO> selectAllWithCompanyName();

<<<<<<< HEAD
    public List<PositionDTO> selectAllByPositionOpenDate();

    public List<PositionDTO> selectAllByPositionDueDate();

    //  검색한 자리 목록
    public List<PositionDTO> selectAllBySearch(Search search);
=======
    public List<PositionDTO> selectByBigCategory(long id);

    public PositionDTO select(long id);
>>>>>>> 3cc62086bb56f45fb9d7ec4681bb912d7e54dbc4
}
