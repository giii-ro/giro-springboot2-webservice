package com.giro.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// JpaRepository <Entity 클래스, PK 타입> -> 기본적인 CRUD 메소드가 자동 생성
public interface
PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p from Posts p order by p.id desc")
    List<Posts> findAllDesc();
}
