package com.example.inkinsight.inkinsight.controller;

import com.example.inkinsight.inkinsight.model.Login;
import com.example.inkinsight.inkinsight.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginService loginService;

    @Test
    public void testSuccessfulLogin() throws Exception {
        // Arrange
        Mockito.when(loginService.log("D", "password1"))
               .thenReturn(new Login("D", "password1"));

        // Act & Assert
        mockMvc.perform(post("/login")
                        .param("username", "D")
                        .param("password", "password1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/welcome"));
    }

    @Test
    public void testFailedLogin() throws Exception {
        // Arrange
        Mockito.when(loginService.log("wronguser", "wrongpass"))
               .thenReturn(null);

        // Act & Assert
        mockMvc.perform(post("/login")
                        .param("username", "wronguser")
                        .param("password", "wrongpass"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(model().attributeExists("error"));
    }
}