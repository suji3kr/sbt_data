package com.company.firstproject.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 자동 증가 설정
    // @SequenceGenerator(name = "article_seq", sequenceName = "article_sequence", allocationSize = 1)

    private Long id;

    private String title;

    private String content;

}
