package com.spring.boardEx01.service;

import java.util.List;

import com.spring.boardEx01.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> listAll();
	public void insert(BoardDTO bdto);
}
