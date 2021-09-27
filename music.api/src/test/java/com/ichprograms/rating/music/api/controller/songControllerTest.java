package com.ichprograms.rating.music.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SongController.class)

public class songControllerTest {
    
    @Autowired
    private MockMvc mvc;
    /*
    @Test
    void getAllSongsInCollection() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/songs/all");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Hello World", result.getResponse().getContentAsString());
    }
    */
}   
