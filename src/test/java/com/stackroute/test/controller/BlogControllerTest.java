package com.stackroute.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.controller.BlogController;
import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This class should test the controller layer and you should write unit tests
 * for saving, fetching, deleting and updating a blog
 */
@ExtendWith(MockitoExtension.class)
public class BlogControllerTest {

    @Mock
    private BlogService blogService;
    private Blog blog;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    BlogController blogController;

    @BeforeEach
    public void setUp(){
        blog = new Blog(1, "John", "Blog Post 1", "Content of Blog Post");
        mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();
    }

    @Test
    public void givenBlogToSaveThenShouldReturnSavedBlog() throws Exception {
        when(blogService.saveBlog(any())).thenReturn(blog);
            mockMvc.perform(post("/api/v1/blog")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(blog)))
                .andExpect(status().isCreated());
        verify(blogService, times(1)).saveBlog(any());
    }

    @Test
    public void givenBlogIdThenShouldReturnRespectiveBlog() throws Exception {
        when(blogService.getBlogById(anyInt())).thenReturn(blog);
            mockMvc.perform(get("/api/v1/blog/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(blog)))
                .andExpect(MockMvcResultMatchers.status().isOk());
        verify(blogService, times(1)).getBlogById(anyInt());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}