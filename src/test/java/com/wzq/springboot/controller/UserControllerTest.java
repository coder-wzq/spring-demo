package com.wzq.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.wzq.springboot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    Gson gson;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void saveUsers() throws Exception {
        // get method
//        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello World")));
        // post form
//        this.mockMvc.perform(post("/insertUser")
//                .param("loginName", "999")
//                .param("age", "666")
//                .param("userLanguage", "CN")
//                .param("description", "junit")
//                .param("password", "test")
//        ).andDo(print())
//        .andExpect(status().isOk());

        User user = new User();
        user.setAge(22);
        user.setLoginName("iiiii");
        user.setDescription("IIII");
        user.setPassword("llllll");
        user.setUserLanguage("CN");
        System.out.println(gson.toJson(user).toString() + "------------");
        System.out.println(objectMapper.writeValueAsString(user) + "------------");
        this.mockMvc.perform(post("/insertUser/").contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(user).toString()))
                .andDo(print()).andExpect(status().isOk());
    }
}
