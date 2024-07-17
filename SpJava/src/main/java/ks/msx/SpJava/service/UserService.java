package ks.msx.SpJava.service;

import ks.msx.SpJava.dto.UserDTO;
import ks.msx.SpJava.entity.User;
import ks.msx.SpJava.repository.UserRepository;
import lombok.AllArgsConstructor;
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
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
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

    public void updateUser(User user){
        userRepository.save(user);
    }

    public User loadUserByEmail(String email){
        return userRepository.getUserByEmail(email).orElseThrow(() -> new RuntimeException("User not found by email"));
    }
}
