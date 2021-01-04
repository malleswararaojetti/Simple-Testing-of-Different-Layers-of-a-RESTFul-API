package com.stackroute.test.repository;

import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class should test the Repository layer and you should write integration tests
 * for saving, fetching, deleting and updating a blog
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BlogRepositoryIntegrationTest {

    @Autowired
    private BlogRepository blogRepository;

    @Test
    public void givenBlogToSaveShouldReturnSavedBlog(){
        Blog blog = new Blog(1, "SpringBoot", "Ravi", "This is a new blog that gives info about SpringBoot");
        blogRepository.save(blog);
        Blog savedBlog = blogRepository.findById(blog.getBlogId()).get();
        assertNotNull(savedBlog);
        assertEquals(blog.getAuthorName(),savedBlog.getAuthorName());
    }

    @Test
    public void givenBlogIdThenShouldReturnRespectiveBlog(){
        Blog blog = new Blog(1, "SpringBoot", "Ravi", "This is a new blog that gives info about SpringBoot");
        blogRepository.save(blog);
        Blog fetchedBlog = null;
        fetchedBlog = blogRepository.findById(1).get();
        assertNotNull(blog);
        assertEquals(fetchedBlog.getBlogTitle(), blog.getBlogTitle());
    }

}