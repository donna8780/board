package com.study_2.board_2.domain.service;

import com.study_2.board_2.domain.dto.req.CreateBoardReqDto;
import com.study_2.board_2.global.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
//트랜젝션 처리 담당(디폴트 값이 서비스 로직에 정상적으로 완료되지않으면 디비에 적용이 되지 않음)
//Transactional : 서비스로직에서 무조건 해줘야 함 (중요)
//작업 중 오류 발생 시 롤백 되도록 보장
@Service
@RequiredArgsConstructor
//RequiredArgsConstructor : 생성자 주입을 자동으로 생성해주는 롬복 어노테이션
//필드 중에서 final로 선언된 멤버 변수에 대해 자동으로 생성자를 만들어줌
//Autowired 대신 사용하는 것

public class CreateBoardService {
    private final BoardMapper boardMapper;
    // @Autowired 대신(@RequiredArgsConstructor) 적어줘야 함


    //게시글 생성
    public void createBoard(CreateBoardReqDto req){
        //클라이언트에게 받아온 dto 정보를 바탕으로 매퍼에게 보내줘야 함
        //요청 dto를 받아서 새로운 게시글을 생성
        boardMapper.createBoard(req.of());
        // dto에서 변환된 board객체를 사용하여 DB에 새 행을 추가-->service에서 dto를 entity로 바꿔주는 것

    }

}
