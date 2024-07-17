package ks.msx.SpJava.controller;

import ks.msx.SpJava.dto.UserDTO;
import ks.msx.SpJava.service.UserService;
import ks.msx.SpJava.utility.ConfirmationToken;
import ks.msx.SpJava.utility.EmailSender;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public String sendVerify(@RequestParam(name = "to_user") String to){
        emailSender.sendMSG(to, "Authentication Token for account activation", confirmationToken.generateConfirmationToken());
        return "sent";
    }

    @RequestMapping("/generate")
    public String generateUUID(){
        return confirmationToken.generateConfirmationToken();
    }

    @RequestMapping("")
    public String verification(@RequestParam(name = "email")String email,
                               @RequestParam(name = "auth_token")String auth_token){
        confirmationToken.confirmation(email, auth_token);
        return "Verification";
    }
}
