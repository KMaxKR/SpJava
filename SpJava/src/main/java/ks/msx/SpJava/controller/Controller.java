package ks.msx.SpJava.controller;

import ks.msx.SpJava.dto.UserDTO;
import ks.msx.SpJava.service.UserService;
import ks.msx.SpJava.utility.ConfirmationToken;
import ks.msx.SpJava.utility.EmailSender;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class Controller {
    private final UserService userService;
    private final EmailSender emailSender;
    private final ConfirmationToken confirmationToken;

    @GetMapping("/")
    public String getFeedback(){
        return "Welcome";
    }

    @RequestMapping("/save")
    public String saveNewUser(@RequestBody UserDTO dto){
        userService.saveUser(dto);
        return "OK";
    }

    @RequestMapping("/send")
    public String sendVerify(){
        emailSender.sendMSG("maxcresciuc@gmail.com", "test", "text");
        return "sent";
    }

    @RequestMapping("/generate")
    public String generateUUID(){
        return confirmationToken.generateConfirmationToken();
    }
}
