package com.classstudies.classquiz.service;

import java.util.List;

import com.classstudies.classquiz.model.exam.Board;



public interface BoardService {

	public Board createBoard(Board board);
	
	public Board updateBoard(Board board);
	
	public Board getBoard(Long id);
	
	public List<Board> getAllBoards();
	
	public void deleteBoard(Long id);
}
