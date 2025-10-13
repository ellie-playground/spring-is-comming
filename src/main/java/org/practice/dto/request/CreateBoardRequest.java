package org.practice.dto.request;

public record CreateBoardRequest(
    String title,
    String content
) {}