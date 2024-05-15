package kg.muhammed.springJwtTokenNew.controller;

import kg.muhammed.springJwtTokenNew.model.AuthenticationResponce;
import kg.muhammed.springJwtTokenNew.model.User;
import kg.muhammed.springJwtTokenNew.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponce> register(@RequestBody User request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponce> login(@RequestBody User request){
        return ResponseEntity.ok(authenticationService.login(request));
    }
}
