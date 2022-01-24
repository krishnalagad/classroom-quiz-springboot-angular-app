package com.classstudies.classquiz.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classstudies.classquiz.model.exam.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
