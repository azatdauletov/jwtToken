package kg.muhammed.springJwtTokenNew.service;

import kg.muhammed.springJwtTokenNew.model.AuthenticationResponce;
import kg.muhammed.springJwtTokenNew.model.User;
import kg.muhammed.springJwtTokenNew.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
     private final JwtService jwtService;
     private final PasswordEncoder passwordEncoder;
     private final AuthenticationManager authenticationManager;
     private final UserRepository repository;

     public AuthenticationResponce register(User request){
         User user = new User();
         user.setFirstName(request.getFirstName());
         user.setLastName(request.getLastName());
         user.setUserName(request.getUsername());
         user.setPassword(passwordEncoder.encode(request.getPassword()));
         user.setEmail(request.getEmail());
         user.setRole(request.getRole());
         user = repository.save(user);
         String token = jwtService.generateToken(user);
         return new AuthenticationResponce(token);
     }

     public AuthenticationResponce login(User request){
         authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(
                         request.getUsername(),
                         request.getPassword()
                 )
         );
         User user = repository.findUserByUserName(request.getUsername()).orElseThrow();
         String token = jwtService.generateToken(user);
         return new AuthenticationResponce(token);
     }
}
