## Problem Statement: Writing unit and integration test cases for the given solution ##

**This exercise should be completed by writing unit and integration test cases using SpringBootTest and Mockito for the solution provided**


- Below is the summary of the solution provided

- This exercise contains a RESTful Service with CRUD operations done on Blog Domain Entity.It contains the following methods in service and controller layer :

           +saveBlog(Blog blog)
            -Should save a blog 
            -Should return blog object
            
           +getAllBlogs()
            -Should fetch all blogs
            -Should return all blogs
            
           +getBlogById(int id)
            -Should retrieve blog by id
            -Should return retrieved blog
            
           +deleteBlog(int id)
            -Should delete a blog
            -Should return the deleted blog
            
           +updateBlog(Blog blog)
            -Should update a blog according to the selected id
            -Should return updated blog
                       
                  
- The test classes in each of the layers Repository, Service and Controller are created
 
    - Write integration tests for repository layer
    - Write unit tests for service layer
    - Write unit tests for controller layer

- Some of the mandatory test cases are mentioned below

    - givenBlogToSaveThenShouldReturnSavedBlog 
    - givenGetAllBlogsThenShouldReturnListOfAllBlogs
    - givenBlogIdThenShouldReturnRespectiveBlog
    - givenBlogIdToDeleteThenShouldReturnDeletedBlog
    - givenBlogToUpdateThenShouldReturnUpdatedBlog


- Minimum test cases expected in service layer : 8
- Minimum test cases expected in controller layer : 5
- Minimum test cases expected in repository layer : 4


- Test cases should be written for positive and negative scenarios, wherever applicable
- Test methods should follow the above mentioned (given...ThenShould) naming convention
- Test coverage should be 100%

## Instructions

- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding

## Code coverage 

 - Run mvn test, the JaCoCo code coverage report will be generated at target/site/jacoco/*
 - Open the target/site/jacoco/index.html file, review the code coverage report 
 
            - Green – Code is tested or covered.
            - Red – Code is not tested or covered.
            - Yellow – Code is partially tested or covered.
 - Make sure lines coverage must meet the minimum 90%
