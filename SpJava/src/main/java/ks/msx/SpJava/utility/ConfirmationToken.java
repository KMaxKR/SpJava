package ks.msx.SpJava.utility;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@AllArgsConstructor
public class ConfirmationToken {
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
        return builder.toString();
    }

    public void confirmation(String user_conf){
        // get conf from db with users info
        // compare tok = user_conf
        // if true => account active else try again conf
    }
}
