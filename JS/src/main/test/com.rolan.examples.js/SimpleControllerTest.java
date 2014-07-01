package com.rolan.examples.js;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class SimpleControllerTest {

    @Autowired
    private WebApplicationContext context;
    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPrintGreetingResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting")).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testGreeting() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$content", Matchers.is("Hello, World!")))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSaveGreeting() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/greeting")
                .content(objectMapper.writeValueAsString(new Greeting(1, "Say Hallelujah")))
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    @Test
    public void testSaveInvalidGreeting() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/greeting")
                .content(objectMapper.writeValueAsString(new Greeting(1, null)))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    @Configuration
    @EnableWebMvc
    public static class SimpleControllerTestConfiguration {

        @Bean
        public SimpleController simpleCOntroller() {
            return new SimpleController();
        }

        @Bean
        @Scope("prototype")
        public ObjectMapper objectMapper() {
            return new ObjectMapper();
        }
    }
}
