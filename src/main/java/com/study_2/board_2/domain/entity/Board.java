package com.study_2.board_2.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class Board {
    private long id;
    private String title;
    private String content;
    private  String author;
    private LocalDateTime created_date;
    private  LocalDateTime updated_date;
    //sql문 보고 board.java 작성


}
