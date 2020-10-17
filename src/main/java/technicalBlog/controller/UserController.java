package technicalBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalBlog.Service.PostService;
import technicalBlog.Service.userService;
import technicalBlog.model.User;
import technicalBlog.model.post;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PostService postService;

    @Autowired
    private userService userService;

    @RequestMapping("users/login")
    public String login(){

        return "users/login";
    }
    @RequestMapping("users/registration")
    public String registration(){
        return "users/registration";
    }

    @RequestMapping(value = "users/login", method= RequestMethod.POST)
    public String loginUser(User user){
            if(userService.login(user)){
            return "redirect:/posts";
        }
        else{
            return "login";
        }
    }

    @RequestMapping(value = "users/logout", method = RequestMethod.POST)
    public String logout(Model model){
        List<post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    @RequestMapping(value = "users/registration", method= RequestMethod.POST)
    public String registration(User user){
        return "users/login";
    }


}
