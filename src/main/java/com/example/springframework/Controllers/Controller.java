package com.example.springframework.Controllers;

import com.example.springframework.DTO.AuthenticationRequest;
import com.example.springframework.DTO.AuthenticationResponse;
import com.example.springframework.Entity.User;
import com.example.springframework.Repo.UserRepository;
import com.example.springframework.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/home")
    public String home() {
        return "This is home page";
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "This is dashboard page";
    }

    @RequestMapping("/manage")
    public String manage() {
        return "This is manage page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Invalid username or password", e);
        }

        final User userDetails = userRepository.findByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
