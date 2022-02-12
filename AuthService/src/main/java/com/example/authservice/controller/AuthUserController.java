package com.example.authservice.controller;

import com.example.authservice.domain.AuthUser;
import com.example.authservice.facade.AuthUserDTO;
import com.example.authservice.facade.NewUserDTO;
import com.example.authservice.facade.RequestDTO;
import com.example.authservice.facade.TokenDTO;
import com.example.authservice.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthUserController {

    @Autowired
    AuthUserService authUserService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody AuthUserDTO dto){
        TokenDTO tokenDto = authUserService.login(dto);
        if(tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDTO> validate(@RequestParam String token, @RequestBody RequestDTO dto){
        TokenDTO tokenDto = authUserService.validate(token, dto);
        if(tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/create")
    public ResponseEntity<AuthUser> create(@RequestBody NewUserDTO dto){
        System.out.println(dto);
        AuthUser authUser = authUserService.save(dto);
        if(authUser == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(authUser);
    }
}

