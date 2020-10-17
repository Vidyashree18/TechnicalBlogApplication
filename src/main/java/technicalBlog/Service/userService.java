package technicalBlog.Service;

import org.springframework.stereotype.Service;
import technicalBlog.model.User;

@Service
public class userService {
    public boolean login(User user){
        if (user.getUsername().equals("validuser")){
            return true;
        }
        else {
            return false;
        }
    }
}
