package org.practice.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.practice.application.BoardService;
import org.practice.domain.Board;
import org.practice.dto.request.CreateBoardRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

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
}
