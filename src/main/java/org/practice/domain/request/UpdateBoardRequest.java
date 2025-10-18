package org.practice.domain.request;

import jakarta.validation.constraints.Size;

public record UpdateBoardRequest(
    String title,

    @Size(max = 2000, message = "내용은 2천자를 초과할 수 없습니다.")
    String content
) {}
