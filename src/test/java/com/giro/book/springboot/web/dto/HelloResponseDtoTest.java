package com.giro.book.springboot.web.dto;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class HelloResponseDtoTest extends TestCase {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test_lombok() throws Exception{
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(name).isEqualTo(dto.getName());
        assertThat(amount).isEqualTo(dto.getAmount());
    }


}