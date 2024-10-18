package com.study_2.board_2.domain.service;

import com.study_2.board_2.domain.dto.resp.GetBoardListPaginationRespDto;
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
public class GetBoardListPaginationService {
    private final BoardMapper boardMapper;
    private  final int pageSize = 10;//한 페이지 당 게시글 수 10개로 고정

    public GetBoardListPaginationRespDto getBoardListPagination(int pageNumber){
        //컨트롤러에서 받아온 pageNumber를 가지고 서비스레이어에서 필요한 정보들의 값을 구한다.

        //1.현재 페이지
        int currentPage = pageNumber;
        //2.페이지 크기 = 10으로 고정
        //3. 오프셋
        int offset = (currentPage-1) * pageSize;
        //4.총 페이지 수(총 페이지 수를 알려면 총 게시글 수를 알아야 한다.)

        //4.1)총 게시글 수
        int totalPosts= boardMapper.getTotalPosts();
        //4.2)총 페이지 수
        int totalPages;

        if(totalPosts % pageSize == 0) {
             totalPages = totalPosts/pageSize;
        }else{
             totalPages = (totalPosts/pageSize) + 1;
        }

        List<Board> board= boardMapper.getBoardListPagination(pageSize, offset);


        //GetBoardListPaginationRespDto에는 List<GetBoardRespDto>가 필요함
        //GetBoardRespDto의 리스트를 만들어줘야 한다. 왜냥??currentpage 등,,이 있기 때문
        List<GetBoardRespDto> boardList = board.stream()
                .map(Board::of)
                .toList();

        return GetBoardListPaginationRespDto.builder()
                .currentPage(currentPage)
                .totalPage(totalPages)
                .boardList(boardList)
                .build();


    }

}

