package com.spring.boardEx01.service;

import java.util.List;

import com.spring.boardEx01.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> listAll() throws Exception;
	public void insert(BoardDTO bdto) throws Exception;
	public BoardDTO read(int num) throws Exception;	// 조회수올리는 것은 따로 만들지 않음
	public boolean modify(BoardDTO bdto) throws Exception;
}
