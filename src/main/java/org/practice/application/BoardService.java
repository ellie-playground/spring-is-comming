package org.practice.application;

import lombok.RequiredArgsConstructor;
import org.practice.domain.Board;
import org.practice.dto.request.CreateBoardRequest;
import org.practice.infrastructure.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Long createBoard(CreateBoardRequest request) {
        Board board = new Board(request.title(),  request.content());
        return boardRepository.save(board).getId();
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }
}
