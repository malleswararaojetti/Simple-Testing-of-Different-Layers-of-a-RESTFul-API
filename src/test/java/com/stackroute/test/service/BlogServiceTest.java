package com.stackroute.test.service;

import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import com.stackroute.service.BlogServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * This class should test the service layer and you should write unit tests
 * for saving, fetching, deleting and updating a blog
 */

@ExtendWith(MockitoExtension.class)
class BlogServiceTest {

    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogServiceImpl blogService;

    @Test
    public void givenBlogToSaveShouldReturnSavedBlog(){
        Blog blog = new Blog(1, "Ravi", "First Blog Post", "New Blog Created");
        when(blogRepository.save(any())).thenReturn(Optional.of(blog));
        blogService.saveBlog(blog);
        verify(blogRepository, times(1)).save(any());
    }

    @Test
    public void givenBlogIdThenShouldReturnRespectiveBlog(){
        Blog blog = new Blog(1, "Ravi", "First Blog Post", "New Blog Created");
        when(blogRepository.findById(anyInt())).thenReturn(Optional.of(blog));
        Blog retrievdBlog = blogService.getBlogById(blog.getBlogId());
        verify(blogRepository, times(1)).findById(anyInt());
    }

}