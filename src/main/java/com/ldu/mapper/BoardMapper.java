package com.ldu.mapper;

import java.util.List;

import com.ldu.model.BoardVO;

public interface BoardMapper {

    /* 게시글 등록 */
	public void enroll(BoardVO board);
	
    /* 게시판 목록 */
    public List<BoardVO> getList();
    
    /* 게시판 조회 */
    public BoardVO getPage(int bno);
}
