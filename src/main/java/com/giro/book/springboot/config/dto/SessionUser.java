package com.giro.book.springboot.config.dto;

import com.giro.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser {
    // Session User에는 인증된 사용자 정보만 필요하므로 name, email, picture 선언
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
