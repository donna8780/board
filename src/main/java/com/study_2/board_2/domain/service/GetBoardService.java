package com.study_2.board_2.domain.service;

import com.study_2.board_2.domain.dto.resp.GetBoardRespDto;
import com.study_2.board_2.domain.entity.Board;
import com.study_2.board_2.global.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class GetBoardService {

    private final BoardMapper boardMapper;

    public GetBoardRespDto getBoard(Long id){
        return boardMapper.getBoard(id).of();
    }

    public List<GetBoardRespDto> getBoardList(){
        //게시글 전체 목록을 받아오니까 List<BoardRespDto>

        List<Board> board = boardMapper.getBoardList();
        //boardMapper.getBoardList()메서드를 호출 =>board테이블 전체를 가져옴
        //그것을 List<Board>타입의 board 변수에 저장 (왜냐하면 boardMapper.getBoardList()
        //의 반환형이 List<Board> != ListGetBoardListRespDto>
        //바로 리턴할 수 없음



        return board.stream()
                //해당 리스트(List<Board>)를 스트림으로 변환
                //스트림을 사용하면 커렉션의 요소들을 쉽게 필터링, 변환 , 정렬할 수 있다.
                .map(Board::of)
                //Board를 GetBoardListRespDto로 변환
                //map은 스트림의 각 요소로 반환할 때 사용
                //board를 of로 변환

                .collect(Collectors.toList());
        //반환한 것들을 List형태로 주워담아서
        //결국 List<GetBoardListRespDto>가 된다.
    }
}
