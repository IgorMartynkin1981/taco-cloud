package ru.martynkin.tacocloud.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.martynkin.tacocloud.User;
import ru.martynkin.tacocloud.data.UserRepository;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserRepository userRepo;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Определение учетных записей для служебных записей памяти
     */
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        List<UserDetails> usersList = new ArrayList<>();
//        usersList.add(
//                new User("buzz", encoder.encode("password"),
//                        List.of((new SimpleGrantedAuthority("ROLE_USER")))));
//        usersList.add(
//                new User("woody", encoder.encode("password"),
//                        List.of((new SimpleGrantedAuthority("ROLE_USER")))));
//        return new InMemoryUserDetailsManager(usersList);
//    }

    /**
     * Определение учетных записей через службу хранения записей
     */
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }
}
