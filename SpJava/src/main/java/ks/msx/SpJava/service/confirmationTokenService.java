package ks.msx.SpJava.service;

import ks.msx.SpJava.entity.confirmationToken;
import ks.msx.SpJava.repository.TokensRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class confirmationTokenService {
    private final TokensRepository confirmation_token_repository;

    public void saveToken(int User_id, int token){
        confirmation_token_repository.save(
                confirmationToken.builder()
                        .user_id(User_id)
                        .confirmation_token(token)
                        .build()
        );
    }
}
