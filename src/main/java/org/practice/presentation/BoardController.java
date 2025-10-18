package org.practice.presentation;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.practice.application.BoardService;
import org.practice.domain.Board;
import org.practice.dto.request.CreateBoardRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

// TODO: ResponseDto로 변경
@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Void> createBoard(@RequestBody @Valid CreateBoardRequest request) {
        Long id = boardService.createBoard(request);
        return ResponseEntity.created(URI.create("/api/v1/boards/" + id)).build();
    }

    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards() {
        return ResponseEntity.ok(boardService.getAllBoards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Long id) {
        Board board = boardService.getBoardById(id);
        if (board == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(board);
    }
}
