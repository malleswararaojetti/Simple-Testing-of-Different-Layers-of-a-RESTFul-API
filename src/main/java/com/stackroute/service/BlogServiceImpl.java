package com.stackroute.service;

import com.stackroute.domain.Blog;

import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;

    /**
     * Constructor based Dependency injection to inject BlogRepository here
     */
    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    /**
     * save a new blog
     */
    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    /**
     * retrieve all blogs
     */
    @Override
    public List<Blog> getAllBlogs() {
        return (List<Blog>) blogRepository.findAll();
    }


    /**
     * retrieve blog by id
     */
    @Override
    public Blog getBlogById(int id) {
        Blog blog = null;
        blog = blogRepository.findById(id).get();
        return blog;
    }

    /**
     * delete blog by id
     */
    @Override
    public Blog deleteBlog(int id) {
        Blog blog = null;
        Optional optional = blogRepository.findById(id);
        if (optional.isPresent()) {
            blog = blogRepository.findById(id).get();
            blogRepository.deleteById(id);
        }
        return blog;
    }

    /**
     * update blog
     */
    @Override
    public Blog updateBlog(Blog blog) {
        Blog updatedBlog = null;
        Optional optional = blogRepository.findById(blog.getBlogId());
        if (optional.isPresent()) {
            Blog getBlog = blogRepository.findById(blog.getBlogId()).get();
            getBlog.setBlogContent(blog.getBlogContent());
            updatedBlog = saveBlog(getBlog);
        }
        return updatedBlog;
    }
}

