package com.giro.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA 엔티티 클래스들이 해당 클래스를 상속할 경우, 클래스에 존재하는 필드들도 칼럼으로 인식함
@EntityListeners(AuditingEntityListener.class) // 해당 클래스에 Auditing 기능을 포함시킴
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
