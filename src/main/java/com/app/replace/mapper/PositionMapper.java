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
    public PositionDTO select(long id);

    public List<PositionDTO> selectAllWithCompanyName();

    public List<PositionDTO> selectAllByPositionOpenDate();

    public List<PositionDTO> selectAllByPositionDueDate();

    //  검색한 자리 목록
    public List<PositionDTO> selectAllBySearch(Search search);
    public List<PositionDTO> selectByBigCategory(long id);
    public void insert(PositionVO positionVO);
    public List<PositionDTO> selectAllByMemberId(long id);
    public int selectPositionCountByMemberId(long id);
    public void deletePositionById(long id);
    public List<PositionDTO> selectFavorites(long id);

}
