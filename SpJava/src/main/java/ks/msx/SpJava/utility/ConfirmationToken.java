package ks.msx.SpJava.utility;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Random;

@Component
@AllArgsConstructor
public class ConfirmationToken {
    // TODO
    // database for confirmation tokens
    // verify token and confirmation

    public int generateConfirmationToken(){
        String CHARS = "1234567890";
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        while (builder.length() < 6){
            int index = (int) (random.nextFloat() * CHARS.length());
            builder.append(CHARS.charAt(index));
        }
        return Integer.valueOf(builder.toString());
    }
}
