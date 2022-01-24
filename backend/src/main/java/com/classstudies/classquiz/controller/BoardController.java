package com.classstudies.classquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classstudies.classquiz.model.exam.Board;
import com.classstudies.classquiz.service.BoardService;


@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin("*")
@RequestMapping("/boards")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/")
	public ResponseEntity<?> add(@RequestBody Board board){
		return ResponseEntity.ok(this.boardService.createBoard(board));
	}
	
	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody Board board){
		return ResponseEntity.ok(this.boardService.updateBoard(board));
	}
	
	
	@GetMapping("/")
	public List<Board> getAll(){
		return this.boardService.getAllBoards();
	}
	
	@GetMapping("/{bid}")
	public Board getOne(@PathVariable("bid") Long bid) {
		return this.boardService.getBoard(bid);
	}
	
	@DeleteMapping("/{bid}")
	public void delete(@PathVariable("bid") Long bid) {
		this.boardService.deleteBoard(bid);
	}


}
