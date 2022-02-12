package com.example.authservice.service;

import com.example.authservice.domain.AuthUser;
import com.example.authservice.facade.AuthUserDTO;
import com.example.authservice.facade.NewUserDTO;
import com.example.authservice.facade.RequestDTO;
import com.example.authservice.facade.TokenDTO;
import com.example.authservice.repository.AuthUserRepository;
import com.example.authservice.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserService {

    @Autowired
    AuthUserRepository authUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    public AuthUser save(NewUserDTO dto) {
        Optional<AuthUser> user = authUserRepository.findByUserName(dto.getUserName());
        if(user.isPresent())
            return null;
        String password = passwordEncoder.encode(dto.getPassword());
        AuthUser authUser = AuthUser.builder()
                .userName(dto.getUserName())
                .password(password)
                .role(dto.getRole())
                .build();
        return authUserRepository.save(authUser);
    }

    public TokenDTO login(AuthUserDTO dto) {
        Optional<AuthUser> user = authUserRepository.findByUserName(dto.getUserName());
        if(!user.isPresent())
            return null;
        if(passwordEncoder.matches(dto.getPassword(), user.get().getPassword()))
            return new TokenDTO(jwtProvider.createToken(user.get()));
        return null;
    }

    public TokenDTO validate(String token, RequestDTO dto) {
        if(!jwtProvider.validate(token, dto))
            return null;
        String username = jwtProvider.getUserNameFromToken(token);
        if(!authUserRepository.findByUserName(username).isPresent())
            return null;
        return new TokenDTO(token);
    }
}

