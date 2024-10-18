package com.study_2.board_2.domain.service;

import com.study_2.board_2.domain.dto.req.UpdateBoardReqDto;
import com.study_2.board_2.domain.entity.Board;
import com.study_2.board_2.global.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class UpdateBoardService {
    private final BoardMapper boardMapper;

    public void updateBoard (Long id, UpdateBoardReqDto req) {
        Board boardTOUpdate = req.of();
        //보드 타입인 이유? boardMapper에서 보드 타입으로 받는다고 명시했기 때문에
        //id값과 합쳐서 bord타입으로 반환해야 하기 때문에

        boardTOUpdate.setId(id);
        //setId를 통해 id값 설정
        boardMapper.updateBoard(boardTOUpdate);
        //id, title, content가 합쳐져서 boardMapper로 보내진다.
    }
}
