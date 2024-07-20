package ks.msx.SpJava.utility;

import ks.msx.SpJava.entity.User;
import ks.msx.SpJava.repository.UserRepository;
import ks.msx.SpJava.service.UserService;
import ks.msx.SpJava.service.confirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@AllArgsConstructor
public class ConfirmationToken {
    private final UserService userService;
    private final confirmationTokenService tokenService;
    // TODO
    // verify token and confirmation

    public String generateConfirmationToken(Long user_id){
        String CHARS = "1234567890";
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        while (builder.length() < 6){
            int index = (int) (random.nextFloat() * CHARS.length());
            builder.append(CHARS.charAt(index));
        }
        tokenService.saveToken( 0 ,Integer.valueOf(builder.toString()));
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
