package com.ldu.mapper;

import java.util.List;

import com.ldu.model.BoardVO;

public interface BoardMapper {

	public void enroll(BoardVO board);
	
    /* 게시판 목록 */
    public List<BoardVO> getList();
}
