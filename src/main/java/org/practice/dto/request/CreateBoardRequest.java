package org.practice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateBoardRequest(
    @NotBlank(message = "제목은 필수입니다.")
    String title,

    @Size(max = 2000, message = "내용은 2천자를 초과할 수 없습니다.")
    String content
) {}