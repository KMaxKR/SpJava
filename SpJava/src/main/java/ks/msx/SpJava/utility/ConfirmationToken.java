package ks.msx.SpJava.utility;

import ks.msx.SpJava.entity.User;
import ks.msx.SpJava.repository.UserRepository;
import ks.msx.SpJava.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@AllArgsConstructor
public class ConfirmationToken {
    private final UserService userService;
    // TODO
    // database for confirmation tokens
    // verify token and confirmation

    public String generateConfirmationToken(){
        String CHARS = "1234567890";
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        while (builder.length() < 6){
            int index = (int) (random.nextFloat() * CHARS.length());
            builder.append(CHARS.charAt(index));
        }
        // save token to db
        return builder.toString();
    }

    public void confirmation(String email, String auth_token){
        User user = userService.loadUserByEmail(email);
        if (user.getAuth_token().equals(auth_token)){
            user.setAuthenticated(true);
            userService.updateUser(user);
        }
    }
}
