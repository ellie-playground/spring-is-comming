package org.practice.domain;

import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DynamicInsert
@Table(name = "board")
public class Board extends Common {

    // TODO: 연관관계 매핑, unique = true 추가
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "likes", nullable = false)
    @ColumnDefault("0")
    private Integer likes;

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
        this.memberId = 0L;
    }
}
