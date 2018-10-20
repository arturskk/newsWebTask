package com.newsTask;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests for Rest Api
 */
public class AppTests extends RestApiTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testClientCategory() throws Exception {
        mockMvc.perform(get("/news/{country}/{category}/", "pl", "technology")
                .param("page", "1"))
                .andDo(System.out::print).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.country").value("pl"))
                .andExpect(jsonPath("$.category").value("technology"));
    }

    @Test
    public void testClientSearch() throws Exception {
        mockMvc.perform(get("/news/{search}/", "poland")
                .param("page", "1"))
                .andDo(System.out::print).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }


}
