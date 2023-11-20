package com.sespitia.weatherapp.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sespitia.weatherapp.auth.AuthController;
import com.sespitia.weatherapp.auth.AuthResponse;
import com.sespitia.weatherapp.auth.LoginRequest;
import com.sespitia.weatherapp.auth.RegisterRequest;
import com.sespitia.weatherapp.auth.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthService authService;

    @Test
    @WithMockUser
    void testLogin() throws Exception {
        LoginRequest loginRequest = new LoginRequest("testuser", "testpassword");
        AuthResponse authResponse = new AuthResponse("testtoken");

        when(authService.login(any(LoginRequest.class))).thenReturn(authResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.token").value("testtoken"));
    }

    @Test
    @WithMockUser
    void testRegister() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest("testuser", "testpassword", "John", "Doe", "US");
        AuthResponse authResponse = new AuthResponse("testtoken");

        when(authService.register(any(RegisterRequest.class))).thenReturn(authResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registerRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.token").value("testtoken"));
    }
}

