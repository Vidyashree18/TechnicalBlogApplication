package technicalBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import technicalBlog.Service.PostService;
import technicalBlog.model.post;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("posts")
    public String getUserPosts(Model model){
        List<post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    @RequestMapping("/posts/newpost")
    public String newPost(){
        return "posts/create";
    }

    @RequestMapping(value = "/posts/create", method= RequestMethod.POST)
    public String createPost(post newPost){
        postService.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.GET)
    public String editPost(@RequestParam(name="postId") Integer postId, Model model) {
        post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.PUT)
    public String editPostSubmit(@RequestParam(name="postId") Integer postId, post updatedPost) {
        updatedPost.setId(postId);
        postService.updatePost(updatedPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/deletePost", method = RequestMethod.DELETE)
    public String deletePostSubmit(@RequestParam(name="postId") Integer postId) {
        postService.deletePost(postId);
        return "redirect:/posts";
    }

}