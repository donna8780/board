package com.study_2.board_2.domain.entity;

import com.study_2.board_2.domain.dto.resp.GetBoardListRespDto;
import com.study_2.board_2.domain.dto.resp.GetBoardRespDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class Board {
    private Long id;
    private String title;
    private String content;
    private  String author;
    private LocalDateTime createdDate;
    private  LocalDateTime updatedDate;
    //sql문 보고 board.java 작성

    public GetBoardRespDto of(){
        //board 엔터티에서 of()메서드를 사용해 GetBoardRespDto를 반환
        //entity-> Dto 변환
        return GetBoardRespDto.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .created_date(this.createdDate)
                .updated_date(this.updatedDate)
                .build();

    }
    public GetBoardListRespDto toDto(){
        return GetBoardListRespDto.builder()
                .id(this.id)
                .title(this.title)
                .author(this.author)
                .created_date(this.createdDate)
                .build();
    }

}
