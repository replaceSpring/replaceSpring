package com.app.replace.service;

import com.app.replace.dao.PositionDAO;
import com.app.replace.dto.PositionDTO;
import com.app.replace.dto.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.Position;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final PositionDAO positionDAO;

    @Override
    public List<PositionDTO> getList(Search search) {
        final List<PositionDTO> positions = positionDAO.findAll(search);
        return positions;
    }
}
