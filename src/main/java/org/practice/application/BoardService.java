package org.practice.application;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.practice.domain.entity.Board;
import org.practice.domain.request.CreateBoardRequest;
import org.practice.domain.request.UpdateBoardRequest;
import org.practice.infrastructure.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Board getBoardById(Long id) {
        // return 값은 Optional<Board>, 값이 없는 경우 null 반환
        // TODO: GlobalExceptionHandler 추가
        return boardRepository.findById(id).orElse(null);
    }

    // Dirty checking에 의한 자동 변경 사항 반영
    @Transactional
    public void updateBoardById(Long id, UpdateBoardRequest request) {
        Board board = boardRepository.findById(id).orElse(null);

        if (board != null) {
            board.updateBoard(request.title(), request.content());
        }
    }
}
