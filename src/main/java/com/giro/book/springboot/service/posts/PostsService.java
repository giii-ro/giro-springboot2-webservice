package com.giro.book.springboot.service.posts;

import com.giro.book.springboot.domain.posts.Posts;
import com.giro.book.springboot.domain.posts.PostsRepository;
import com.giro.book.springboot.web.dto.PostsResponseDto;
import com.giro.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다.")
        );
        return new PostsResponseDto(entity);
    }

    public Long update(Long id, PostsSaveRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 없습니다. id = " + id)
        );

        // 이 부분에서 db에 쿼리를 날리는 부분이 x -> JPA의 영속성 컨텍스트이기때문에 가능
        // 따라서 해당 데이터 값을 변경하면 "트랙젠션이 끝나는 시점"에 해당 테이블에 변경분을 반영
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
}
