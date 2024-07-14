package ks.msx.SpJava.service;

import ks.msx.SpJava.dto.UserDTO;
import ks.msx.SpJava.entity.User;
import ks.msx.SpJava.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByUsername(username);
    }

    public void saveUser(UserDTO dto){
            userRepository.save(User.builder()
                            .username(dto.getUsername())
                            .password(new BCryptPasswordEncoder(12).encode(dto.getPassword()))
                            .email(dto.getEmail())
                            .isActive(true)
                            .auth_token(UUID.randomUUID().toString())
                    .build());
    }
    public void verifyAccount(String email, String auth_token){
        User user = userRepository.getUserByEmail(email);
        // verify authentication token from database with email message confirmation
        if (user.getAuth_token().equals(auth_token)){
            user.setAuthenticated(true);
            userRepository.save(user);
        }
    }
}
