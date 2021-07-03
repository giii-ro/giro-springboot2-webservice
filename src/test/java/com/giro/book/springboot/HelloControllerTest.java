package com.giro.book.springboot;

import com.giro.book.springboot.web.HelloController;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
// 테스트를 진행할 때 Junit에 내장된 실행자 외에 다른 실행자를 실행시킴
// 스프링 부트 테스트와 JUnit사이에 연결자 역할을 함

@WebMvcTest(controllers = {HelloController.class}, secure = false)
// 여러 스프링 테스트 어노테이션 중 Web에 집중할 수 있는 어노테이션
// 여기서는 컨트롤러만 사용하므로 사용

public class HelloControllerTest extends TestCase {
    @Autowired // 스프링이 관리하는 빈을 주입받음
    private MockMvc mvc; // 웹 API를 테스트할 때 사용함, HTTP GET, POST 등에 대한 API 테스트를 할 수 있음

    @Test
    public void test_hello가_리턴된다() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함
                .andExpect(status().isOk()) // http header의 Status를 검증
                .andExpect(content().string(hello)); // perform의 결과를 검증

    }

    @Test
    public void test_helloDto_return() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}