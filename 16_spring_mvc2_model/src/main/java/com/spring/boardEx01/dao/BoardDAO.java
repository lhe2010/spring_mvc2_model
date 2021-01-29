package com.spring.boardEx01.dao;

import java.util.List;

import com.spring.boardEx01.dto.BoardDTO;

public interface BoardDAO {
	
	public List<BoardDTO> getAllBoard() throws Exception;
	public void insertBoard(BoardDTO bdto) throws Exception;
	public BoardDTO getOneBoard(int num) throws Exception;
	public void increaseReadCount(int num) throws Exception;
}
