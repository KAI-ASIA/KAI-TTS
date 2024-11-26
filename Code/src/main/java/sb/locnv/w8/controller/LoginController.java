package sb.locnv.w8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sb.locnv.w8.entity.Users;
import sb.locnv.w8.service.UserService;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody Users userLogin){
        return userService.login(userLogin);
    }

}
