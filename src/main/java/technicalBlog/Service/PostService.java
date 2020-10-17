package technicalBlog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalBlog.model.post;
import technicalBlog.repository.PostRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public PostService(){
        System.out.print("*** Home Controller ***");
    }

    public List<post> getAllPosts(){
        return repository.getAllPosts();
    }

    public post getOnePost(){
        return repository.getLatestPost();
    }

    public void createPost(post newPost){
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("New Post: " + newPost);
    }

    public post getPost(Integer postId){
        return repository.getPost(postId);
    }

    public void updatePost(post updatedPost){
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId){
        repository.deletePost(postId);
    }

}
