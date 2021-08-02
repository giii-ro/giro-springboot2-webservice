package com.giro.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스임을 나타냄
// 글래스의 카멜케이스 이름 -> 언더스코어 네이밍으로 테이블 이름을 매칭
// Entity 클래스에서는 절대 Setter 메소드를 만들지 않음
public class Posts {
    @Id // 테이블의 pk필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk의 생성 규칙을 나타냄
    private Long id;                                    // GenerationType.IDENTITY 규칙 적용 -> auto_increment
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition ="TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스(?)를 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
