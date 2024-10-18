package com.study_2.board_2.domain.controller;

import com.study_2.board_2.domain.dto.req.CreateBoardReqDto;
import com.study_2.board_2.domain.dto.req.UpdateBoardReqDto;
import com.study_2.board_2.domain.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//= @Responsebody + @Controller
@RequestMapping("/board")
@RequiredArgsConstructor //의존성 주입을 간편하게 할 수 있다.
public class BoardController {
    private final CreateBoardService createBoardService;
    private final GetBoardService getBoardService;
    private final DeleteBoardService deleteBoardService;
    private final UpdateBoardService updateBoardService;
    private final GetBoardListPaginationService getBoardListPaginationService;

    //게시글 생성(POST)
    //RequestBody를 사용하면 본문에서 json데이터를 읽어 와서 지정한 dto 객체(CreateBoardDto)로 자동 변환해 줌
    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody CreateBoardReqDto req){

        createBoardService.createBoard(req);

        return ResponseEntity.status(HttpStatus.CREATED).body("게시판 생성 완료");
    }

    //게시글 상세 조회(GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getBoard(@PathVariable Long id){
        return ResponseEntity.ok().body(getBoardService.getBoard(id));

    }
    //게시글 목록 조회(GET)
    @GetMapping("/list")
    public ResponseEntity<?> getBoardList(){
        return ResponseEntity.ok(getBoardService.getBoardList());
}

    //게시글 삭제(DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id){

        deleteBoardService.DeleteBoard(id);

        return ResponseEntity.ok().body("삭제");
    }


    //게시글 업데이트
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Long id, @RequestBody UpdateBoardReqDto req){
        updateBoardService.updateBoard(id, req);

        return ResponseEntity.ok().body("게시글 수정 완료");
    }
    //게시글 목록 조회(Pagination)
    @GetMapping("/list/{pageNumber}")
    public ResponseEntity<?> getBoardListPagination(@PathVariable int pageNumber){
        return ResponseEntity.ok().body(getBoardListPaginationService.getBoardListPagination(pageNumber));
    }
}
