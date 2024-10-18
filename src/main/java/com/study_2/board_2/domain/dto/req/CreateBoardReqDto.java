package com.study_2.board_2.domain.dto.req;

import com.study_2.board_2.domain.entity.Board;

import java.time.LocalDateTime;

//레코드로 생성하는 이유? 간결하고 불변성이 보장된 클래스를 만드는 데 유용, 코드 가독성 증가
public record CreateBoardReqDto(
        String title,
        String content,
        String author

        //dto->클라이언트와 서버 간 데이터 전송을 위해 필요한 최소한의 정보만 담음
) {
    //요청 받은 데이터 한 줄을(게시글 하나 작성) 객체로 만드는 작업
    public Board of(){
        //클라이언트로부터 받아온 정보를 가지고 board테이블에 행 추가
        return Board.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }


}
