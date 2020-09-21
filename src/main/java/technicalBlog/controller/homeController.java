package technicalBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalBlog.model.post;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class homeController {
    @RequestMapping("/")
    public String getAllPosts(Model model){

        ArrayList<post> posts = new ArrayList<>();

        post Post1 = new post();
        Post1.setTitle("Post 1");
        Post1.setBody("Body 1");
        Post1.setDate(new Date());

        post Post2 = new post();
        Post2.setTitle("Post 2");
        Post2.setBody("Body 2");
        Post2.setDate(new Date());

        post Post3 = new post();
        Post3.setTitle("Post 3");
        Post3.setBody("Body 3");
        Post3.setDate(new Date());

        posts.add(Post1);
        posts.add(Post2);
        posts.add(Post3);

        model.addAttribute("posts", posts);

        return "index";
    }
}
