package technicalBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalBlog.Service.PostService;
import technicalBlog.Service.userService;
import technicalBlog.model.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class homeController {

    public homeController(){
        System.out.print("*** Post Controller ***");
    }

    @Autowired
    private PostService postService;

    @Autowired
    private userService userService;

    @RequestMapping("/")
    public String getAllPosts(Model model){

        List<post> posts = postService.getAllPosts();

        model.addAttribute("posts", posts);

        return "index";
    }
}
