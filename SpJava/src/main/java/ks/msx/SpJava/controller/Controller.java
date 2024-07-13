package ks.msx.SpJava.controller;

import ks.msx.SpJava.dto.UserDTO;
import ks.msx.SpJava.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {
    private final UserService userService;

    @GetMapping("/")
    public String getFeedback(){
        return "Welcome";
    }

    @RequestMapping("/save")
    public String saveNewUser(@RequestBody UserDTO dto){
        userService.saveUser(dto);
        return "OK";
    }
}
