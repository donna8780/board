package com.study_2.board_2.global.mapper;

import com.study_2.board_2.domain.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//레포지토리 입니다!
@Mapper
public interface BoardMapper {
    //게시글 생성 반환형 void
    void createBoard(Board board);

    //게시글 목록 조회 List<Board>
    List<Board> getBoardList();

    //게시글 상세 조회 Board - id가 프라이머리키라서 매개변수로 id가 들어옴
    Board getBoard(Long id);

    //게시글 업데이트 - 게시물 여러 가지가 수정되니까 Board타입
    void updateBoard(Board board);

    //게시글 삭제void - 아이디 선택해서 게시물 하나 삭제하니까 id가 매개변수로
    void deleteBoard(Long id);

}
