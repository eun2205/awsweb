package com.aws.web.springboot;

import com.aws.web.springboot.web.HelloController;
import com.aws.web.springboot.web.dto.HelloResDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

   @Test
    public void 롬복_기능_테스트() {
        String name = "lombok";
        int amount = 1000;

       HelloResDto helloResDto = new HelloResDto(name, amount);

       assertThat(helloResDto.getName()).isEqualTo(name);
       assertThat(helloResDto.getAmount()).isEqualTo(amount);
   }

   @Test
    public void dto가_리턴된다() throws Exception {
        String name = "milk";
        int amount = 2000;

        mockMvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
   }
}
